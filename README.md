
# K-DataPortal

## Overview
**K-DataPortal**은 한국 공공데이터 포털 API를 Java에서 쉽게 활용할 수 있도록 돕는 라이브러리입니다.  
복잡한 URL 빌드와 HTTP 요청 과정을 간소화하여 공공 데이터를 빠르고 효율적으로 활용할 수 있습니다.

⚠️ **현재 개발 초기 단계로 일부 API만 지원합니다.** 지속적인 확장이 예정되어 있습니다.

---

## Features
- **간단한 API 요청**: 공공데이터 포털의 주요 서비스 엔드포인트 지원
- **유연한 URL 빌딩**: API 호출을 위한 직관적인 URL 빌더 제공
- **자동 JSON 응답 처리**: 요청 결과를 문자열로 간편히 반환

현재 지원하는 서비스:
1. **정류장 정보 조회** (`getSttnInfo`)
2. **노선 정보 조회** (`getRouteInfo`)
3. **버스 위치 정보 조회** (`getLocationInfo`)
4. **버스 도착 정보 조회** (`getArrivalInfo`)

---

## Installation
프로젝트에서 라이브러리를 사용하려면, `K-DataPortal` 소스를 가져와 Java 프로젝트에 포함하세요.

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
