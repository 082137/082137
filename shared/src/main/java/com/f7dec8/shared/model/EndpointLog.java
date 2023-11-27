package com.f7dec8.shared.model;

import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class EndpointLog extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 시그니쳐
     * <p>호출된 메서드의 정보를 나타냅니다.</p>
     */
    @Column
    private String signature;
    
    /**
     * 요청 메서드
     * <p>
     * 클라이언트가 사용한 HTTP 메서드(GET, POST, PUT, DELETE 등)를 기록합니다.
     * </p>
     */
    @Column
    @Enumerated(EnumType.STRING)
    private RequestMethod method;

    /**
     * 경로
     * <p>
     * 클라이언트가 요청한 엔드포인트의 경로를 기록합니다.
     * </p>
     * <p>
     * 이는 어떤 API 또는 서비스가 호출되었는지를 명확히 파악하는 데 도움이 됩니다.
     * </p>
     */
    @Column
    private String path;

    /**
     * 파라미터
     * <p>
     * 요청으로 전달된 파라미터들을 기록합니다.
     * </p>
     * <p>
     * 이는 클라이언트가 어떤 데이터를 서버에 전달했는지를 확인하는 데 도움이 됩니다.
     * </p>
     */
    @Lob
    @Column
    private String parameters;

    /**
     * 반환 데이터
     * <p>
     * 서버가 클라이언트에게 반환한 데이터를 기록합니다.
     * </p>
     * <p>
     * 어떤 응답이 클라이언트에게 전송되었는지를 확인하는 데 유용합니다.
     * </p>
     */
    @Lob
    @Column
    private String responseBody;

    /**
     * 응답 상태 코드
     * <p>
     * 서버의 응답 상태 코드를 기록합니다.
     * </p>
     * <p>
     * 성공, 실패, 에러 등의 상태를 파악할 수 있습니다.
     * </p>
     */
    @Column
    private int responseStatusCode;

    /**
     * 요청 시간(milliseconds)
     * <p>
     * 엔트리포인트의 실행에 걸린 시간을 측정하고 기록합니다.
     * </p>
     * <p>
     * 성능 모니터링에 도움이 됩니다.
     * </p>
     */
    @Column
    public double executionTimeMillis;

    /**
     * 요청자의 IP 주소
     * <p>
     * 클라이언트의 IP 주소를 기록하여 요청이 어디서 왔는지를 추적합니다.
     * </p>
     */
    @Column
    public String clientIpAddress;

}
