# K-DataPortal

## Overview
**K-DataPortal**은 한국 공공데이터 포털 API를 Java에서 쉽게 활용할 수 있도록 돕는 라이브러리입니다.  
복잡한 URL 빌드와 HTTP 요청 과정을 간소화하여 공공 데이터를 빠르고 효율적으로 활용할 수 있습니다.

⚠️ **현재 개발 초기 단계로 일부 API만 지원합니다.** 지속적인 확장이 예정되어 있습니다.

---

## Features
- **간단한 API 요청**: 공공데이터 포털의 주요 서비스 엔드포인트 지원
- **유연한 URL 빌딩**: API 호출을 위한 직관적인 URL 빌더 제공
- **자동 JSON 응답 처리**: 요청 결과를 POJO 클래스로 변환하여 간편히 활용 가능
- **디버그 모드**: API 호출 응답 데이터를 콘솔에 출력 가능

현재 지원하는 서비스:
1. **도시 코드 조회** (`getCityCodes`)
2. **정류장 정보 조회** (`getNearbyStations`, `getStationArrivalInfo`)
3. **노선 정보 조회** (`getRouteInfo`, `getBusRouteLocations`)
4. **버스 도착 정보 조회** (`getRouteArrivalInfo`)

---

## Installation
### Prerequisites
- Java 8 이상
- Gson 라이브러리 (JSON 파싱을 위해 필요)

### 프로젝트에 포함하기
1. 제공된 소스 코드를 프로젝트에 추가하세요.
2. 의존성 추가 (Gradle):
   ```gradle
   implementation 'com.google.code.gson:gson:2.10'
   ```

---

## Usage

### 1. API Key 설정
`DataPortalKeyDemo` 클래스 위치에 **Demo**클래스를 복사 붙여넣기하여 `DataPortalKey` 클래스를 생성한 뒤 **서비스키**를 넣은 뒤 사용하세요.
```java
package kr.codingtree.util.kdataportal;

@UtilityClass
public class DataPortalKey {
    public final String USER_KEY = "YOUR_SERVICE_KEY_HERE";
}
```

### 2. 주요 메소드 사용법

#### 2.1 도시 코드 조회 (`getCityCodes`)
- 도시 코드와 도시 이름을 조회하여 `HashMap`으로 반환합니다.

```java
HashMap<Integer, String> cityCodes = KDataPortal.getCityService().getCityCodes();

cityCodes.forEach((cityCode, cityName) -> {
    System.out.println("City Code: " + cityCode + ", City Name: " + cityName);
});
```

---

#### 2.2 근처 정류장 조회 (`getNearbyStations`)
- 특정 GPS 좌표를 기준으로 근처 정류장 정보를 가져옵니다.

```java
NearbyBusStationsResponse nearbyStations = KDataPortal.getBusService().getNearbyStations(1, 10, 37.67777, 126.79619);
System.out.println(nearbyStations);
```

---

#### 2.3 특정 정류장 도착 정보 조회 (`getStationArrivalInfo`)
- 특정 정류장의 도착 예정 버스 정보를 조회합니다.

```java
BusArrivalInfoResponse arrivalInfo = KDataPortal.getBusService().getStationArrivalInfo(1, 10, 25, "NODE_ID");
System.out.println(arrivalInfo);
```

---

#### 2.4 특정 노선 도착 정보 조회 (`getRouteArrivalInfo`)
- 특정 정류장에서 특정 노선의 도착 정보를 조회합니다.

```java
BusArrivalInfoResponse routeArrival = KDataPortal.getBusService().getRouteArrivalInfo(1, 10, 25, "NODE_ID", "ROUTE_ID");
System.out.println(routeArrival);
```

---

#### 2.5 노선 정보 조회 (`getRouteInfo`)
- 특정 노선의 상세 정보를 조회합니다.

```java
BusRouteInfoResponse routeInfo = KDataPortal.getBusService().getRouteInfo(25, "ROUTE_ID");
System.out.println(routeInfo);
```

---

#### 2.6 특정 노선의 버스 위치 조회 (`getBusRouteLocations`)
- 특정 노선의 실시간 버스 위치 정보를 조회합니다.

```java
BusRouteLocationsResponse busLocations = KDataPortal.getBusService().getBusRouteLocations(1, 10, 25, "ROUTE_ID");
System.out.println(busLocations);
```

---

## Debug Mode
디버그 모드를 활성화하면 API 호출 응답 데이터를 콘솔에 출력할 수 있습니다:

```java
KDataPortal.setDebugMode(true);
```

