import axios, { type AxiosResponse, type CreateAxiosDefaults, type InternalAxiosRequestConfig } from 'axios';
import { LRUCache } from 'lru-cache';
import { stringify } from 'qs';

export interface ResponseData {
  ttt: string;
}

export interface RequestConfig extends InternalAxiosRequestConfig {
  isCached?: boolean;
}

export interface InternalAxiosResponse extends Omit<AxiosResponse, 'config'> {
  config: RequestConfig;
}

export interface DefaultAxiosOptions extends CreateAxiosDefaults {}

function getKey(config: RequestConfig) {
  const { url, params, paramsSerializer } = config;
  const builtURL = axios.getUri({ url, params, paramsSerializer });
  const [urlPath, queryString] = builtURL.split('?');
  return queryString ? `${urlPath}?${queryString.split('&').sort().join('&')}` : builtURL;
}

export function createDefaultAxios(options: DefaultAxiosOptions = {}) {
  const cache = new LRUCache<string, InternalAxiosResponse>({ max: 100, ttl: 5000 /* 5s */ });

  const instance = axios.create({
    headers: { 'Content-Type': 'application/json' },
    paramsSerializer: { serialize: (params) => stringify(params, { arrayFormat: 'comma' }) },
    withCredentials: true,
    ...options,
  });

  instance.interceptors.request.use((config: RequestConfig) => {
    const { isCached = true, method } = config;
    if (isCached && method === 'get') {
      const key = getKey(config);
      if (cache.has(key)) {
        const res = cache.get(key);
        if (res) {
          try {
            config.adapter = () => Promise.resolve(res);
          } catch {
            cache.delete(key);
          }
        }
      }
    }
    return config;
  });

  instance.interceptors.response.use((res: InternalAxiosResponse) => {
    const { config } = res;
    const { isCached = true, method } = config;
    if (isCached && method === 'get') {
      cache.set(getKey(config), res);
    }
    return res;
  });

  return instance;
}
