# ReadMe

## 서버(Server) 브랜치를 Fork하여 새로운 저장소(Main)를 만드는 방법

1. 원본 Starter 저장소를 Fork하여 본인의 GitHub 계정에 복제합니다.
2. Fork한 저장소를 로컬로 Clone합니다.

   ```bash
   git clone <Fork한 저장소 URL>
   ```

3. 로컬에서 새로운 브랜치(Main)를 생성하고 작업을 수행합니다.

   ```bash
   git checkout -b main
   # 작업을 수행하세요
   ```

4. 변경 내용을 Commit하고 Fork한 저장소(Main)로 Push합니다.

   ```bash
   git commit -m "새로운 기능 추가"
   git push origin main
   ```

## 클라이언트(Client) 브랜치를 Fork하여 새로운 저장소(Main)를 만드는 방법

1. 원본 Starter 저장소를 Fork하여 본인의 GitHub 계정에 복제합니다.
2. Fork한 저장소를 로컬로 Clone합니다.

   ```bash
   git clone <Fork한 저장소 URL>
   ```

3. 로컬에서 새로운 브랜치(Main)를 생성하고 작업을 수행합니다.

   ```bash
   git checkout -b main
   # 작업을 수행하세요
   ```

4. 변경 내용을 Commit하고 Fork한 저장소(Main)로 Push합니다.

   ```bash
   git commit -m "새로운 기능 추가"
   git push origin main
   ```

## 서버(Server) 브랜치의 Fork로부터 새로운 저장소(Main)로 Pull하는 방법 (Merge 기준)

1. Fork한 저장소(Main)로 이동합니다.

   ```bash
   git checkout main
   ```

2. 원본 Starter 저장소를 원격 저장소로 추가합니다.

   ```bash
   git remote add upstream <원본 Starter 저장소 URL>
   ```

3. 원본 Starter 저장소에서 변경 사항을 가져옵니다.

   ```bash
   git fetch upstream
   ```

4. 로컬 브랜치(Main)에서 원본 Starter 저장소의 변경 사항을 병합(Merge)합니다.

   ```bash
   git merge upstream/main
   ```

5. 변경 사항을 로컬(Main) 브랜치에서 Fork한 저장소(Main)로 Push합니다.

   ```bash
   git push origin main
   ```

## 클라이언트(Client) 브랜치의 Fork로부터 새로운 저장소(Main)로 Pull하는 방법 (Merge 기준)

1. Fork한 저장소(Main)로 이동합니다.

   ```bash
   git checkout main
   ```

2. 원본 Starter 저장소를 원격 저장소로 추가합니다.

   ```bash
   git remote add upstream <원본 Starter 저장소 URL>
   ```

3. 원본 Starter 저장소에서 변경 사항을 가져옵니다.

   ```bash
   git fetch upstream
   ```

4. 로컬 브랜치(Main)에서 원본 Starter 저장소의 변경 사항을 병합(Merge)합니다.

   ```bash
   git merge upstream/main
   ```

5. 변경 사항을 로컬(Main) 브랜치에서 Fork한 저장소(Main)로 Push합니다.

   ```bash
   git push origin main
   ```

<!--
### Hi there 👋

**082137/082137** is a ✨ _special_ ✨ repository because its `README.md` (this file) appears on your GitHub profile.

Here are some ideas to get you started:

- 🔭 I’m currently working on ...
- 🌱 I’m currently learning ...
- 👯 I’m looking to collaborate on ...
- 🤔 I’m looking for help with ...
- 💬 Ask me about ...
- 📫 How to reach me: ...
- 😄 Pronouns: ...
- ⚡ Fun fact: ...
-->
