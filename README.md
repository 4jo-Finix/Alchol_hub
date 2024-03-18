# Alcohol Hub(Ahub Project)
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/09e4c600-a088-4b1b-97d8-9f67b80e7e03)

### 팀명: 불4조(Team Phoenix)
### 팀원

- 팀원 : **백동현**
[<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/dongh810)

- 팀원 : **손세림**
[<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/bucky1005)

- 팀원 : **송동준**
[<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/dongjunsong)

- 팀원 : **양지혜**
[<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/Jihye1101)

- 팀원 : **정태원**
[<img src="https://img.shields.io/badge/Github-Link-181717?logo=Github">](https://github.com/t4e1)

---

# 1. 프로젝트 개요

 Alcohol Hub 프로젝트(이하 Ahub)는 COVID-19 이후 급격하게 성장하는 수입 주류 시장에 발맞춰, 주종별로 폐쇄적인 환경에서 운영되던 기존의 커뮤니티들과 달리, 수입 주류 전반에 걸쳐 행사와 이벤트 정보를 제공하는 서비스 입니다.   

## 1-1 필요성
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/9d3ce8dd-9469-42fa-97d6-83d1511b95e7)
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/cf754126-a85a-4f27-89e7-bff0cf64f4e9)


 관세청에서 제공한 수입 주류 수입액 통계에 의하면, 2019년 코로나19 발생 이후 수입 주류에 대한 수요는 꾸준히 증가하고 있다는 사실을 확인할 수 있습니다. 기존의 소주와 맥주 위주로 소비되던 주류 시장에서, 2030 세대를 기준으로 와인과 위스키 등 수입 주류 시장으로 주류 소비의 트렌드가 확장되고 있으며, 이는 현재 하이볼이나 칵테일의 유행으로 알 수 있듯이 하나의 주종(酒種)으로서의 유행이 아니라 믹솔로지(Mixology)라는 새로운 트랜드와 맞닿아 있는 하나의 흐름인 것을 확인할 수 있습니다. <br>
 하지만 커져가는 시장 규모와 달리 수입 주류 정보를 얻을 수 있는 행사에 대한 정보를 얻을 수 있는 사이트는 주류 별로 제한되어 있고, 사용자들의 니즈를 충족하기 위해서는 이를 통합적으로 관리하여 정보를 제공할 수 있는 사이트의 필요성이 새로이 제시되고 있습니다. 

<br>

# 2. 프로젝트 작업 범위

Ahub 프로젝트의 산출 결과물은 다음과 같습니다.

- **요구사항 명세서** : 프로젝트의 요구사항을 정리하여 기능별로 분류해둔 문서 
- **도메인 주도 개발(DDD) 설계도** : 프로젝트의 기능을 도메인으로 나누고, 생성된 도메인을 중요도에 따라 핵심,지원,일반으로 분류 
- **데이터베이스 논리/물리모델** : 프로젝트에 사용할 데이터베이스 생성을 위해 논리/물리 모델링을 구현 
- **웹 어플리케이션 실행 파일** : 실제 기능들이 구현되는 프로젝트 파일   
- **테스트 케이스 정의서** : 요구사항에 해당하는 테스트를 작성 및 진행, 해당 결과를 보여주는 문서 
- **REST-API 명세서** : REST-API의 테스트 결과를 보여주는 문서 

## 2-1 추진 계획

*테이블 1: 추진체계*

| 구분 | 조직 | 주요 역할 |
| --- | --- | --- |
| 주관 | 불4조 (Team Phoenix) | 백엔드 프로젝트 |
| 지원기관 | 한화시스템x엔코아 | 장비 지원 및 퀄리티 점검 |

**프로젝트 일정** : 2024-02-26 ~ 2024-03-11

**작업 공간** : 서울 동작구 보라매로 SFC빌딩, 원격 소통

**기술 스택** : <img src ="https://img.shields.io/badge/MariaDB-&logo=MariaDB"/><img src="https://img.shields.io/badge/10.6-515151?style=for-the-badge" width="40" height="20"/> <img src="https://img.shields.io/badge/OpenJDK-&logo=openjdk"><img src="https://img.shields.io/badge/17.0.3-515151?style=for-the-badge" width="40" height="20"/>
<img src ="https://img.shields.io/badge/Spring Boot-&logo=Spring Boot"/><img src="https://img.shields.io/badge/3.0.3-515151?style=for-the-badge" width="50" height="20"/> 
<img src="https://img.shields.io/badge/Spring Security-&logo=spring security" width="70" height="20"/>
<img src="https://img.shields.io/badge/Spring Data JPA-&logo=spring data jpa" width="100" height="20"/>
<img src="https://img.shields.io/badge/MyBatis-&logo=mybatis" width="50" height="20"/>
<img src="https://img.shields.io/badge/Spring Cloud Gateway-&logo=spring cloud gateway" width="100" height="20"/>


## 2-2  일정관리 (WBS)

![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/096d31f2-a412-42ac-9060-40e8ed8ea18d)

<br>

# 3. 프로젝트 설계

프로젝트 설계 항목에서는 프로젝트 기능 구현에 필요한 요구사항 파악과, 해당 요구사항을 구현하기 위한 프로젝트의 설계를 확인할 수 있습니다. 

## 3-1 요구사항 명세서
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/c35bf325-8f7f-4afa-9dc5-db1f2e128f85)
    
## 3-2. DDD 

- Event Storming <br>
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/8010e804-a156-49aa-bdeb-6b9a92508bb0)

- Bounded Context
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/bad37322-a598-4c3c-9977-cc160471a7b1)

- Context Map
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/b6a80658-3d07-4161-b46c-78e96c188ae9)


## 3-3 DB 모델링
-  DA# 논리 모델 
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/ac63be56-bcb9-4715-921d-21f4c9ccf151)

- DA# 물리 모델
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/092dabe3-8721-4ef9-9dbc-d9867ba43579)

## 3-4 네트워크 아키텍처 
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/b820bcc8-b244-4d03-86a3-5b6ac8da2230)

<br>

## 4. TEST 

### 4-1. TESTCASE Definition
- **TESTCASE(Member) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/019a79ad-f3fc-4d80-a4a4-146fd5aae4e0)

<details>
<summary>Test Result</summary>
 <br>
 
 **CRUD** <br>
![command](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/295b2b71-3426-4336-b1d9-dad3f157a448)

**SELECT** <br>
![queryTest](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/c111e3db-2802-416d-943b-fcb878e57c4c)

</details>

---

- **TESTCASE(Fair) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/bcf425b7-a185-4e01-9f76-d0f9666a79d1)

<details>
<summary>Test Result</summary>
<br> 

**CRUD** <br>
 
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/844ab5f0-6337-45e7-ad0f-1feff2c3b133)

**SELECT** <br>

![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/896a09d9-553f-4b91-96c8-c172c1c874b2)

</details>

---

- **TESTCASE(News) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/fc5e3a27-e1e8-4088-be21-e939aa5e8f47)


<details>
<summary>Test Result</summary>
<br>
 
**CRUD** <br>
 ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/910753e3-92f0-4078-8d90-5d8c2c79d991)

**SELECT** <br>
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/27cb5e77-83dd-4cbe-97a3-aef638d37998)


</details>

---

- **TESTCASE(Reply) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/2497da07-5f6b-47bd-9df6-6cddec4a91e1)

<details>
<summary>Test Result</summary>
<br> 

**CRUD** <br>

<img width="702" alt="스크린샷 2024-03-10 오후 9 40 00" src="https://github.com/dongh810/alcohol_test/assets/105986200/904961a1-9346-4c7e-a6ff-ee1e5671fbd2">

**SELECT** <br>

<img width="702" alt="스크린샷 2024-03-10 오후 9 40 09" src="https://github.com/dongh810/alcohol_test/assets/105986200/678f792b-d989-457f-9945-a5441a4419d4">
 

</details>

---

- **TESTCASE(Post) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/61707680-fa22-4963-839b-a504704a7888)


<details>
<summary>Test Result</summary>
<br> 

**CRUD** <br>
 ![포스트서비스임플테스트](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/153909291/be9d68f3-931e-4122-8b7d-3f356089bc71)


**SELECT** <br>
![포스트서비스테스트](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/153909291/380c4f98-feea-40dd-ac2f-6f5a41570df2)


</details>

<br>

### 4-2. REST-API Definition
- **REST-API(Member) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/a0d0ab03-5595-4cdb-af22-7043423ee460)
<details>
<summary>AH-MEMBER-001</summary>

- **Request Header**
![01_Request_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/1dd83fed-5c6c-4706-ac3d-6895c6f61bb6)

- **Response Header**
![01_Response_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/5f27a935-ed7a-4337-884e-c235429819a9)

- **Response Body**
![01_GET_findAllmembers](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/88b0f378-5162-4611-be3b-d4ad3703adac)
![01_GET_findAllmembers_2](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/b08b802b-2196-4f61-ba0c-8237b6736019)

</details>

<details>
<summary>AH-MEMBER-002</summary>

- **Request Header**
![02_Request_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/aa051b8b-29c6-4041-a073-2343e6489033)

- **Response Header**
![02_Response_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/0dc9d380-17fc-44c1-abc6-91c1de1d074c)

- **Response Body**
![02_GET_findBymemberCode](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/2f115a8b-d589-4018-a4f1-36cfeaf8dc2c)

</details>

<details>
<summary>AH-MEMBER-003</summary>

- **Request Header**
![03_Request_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/2c075c2e-8ff4-4a19-ae7e-6551c83cece1)

- **Response Header**
![03_Response_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/7c8205dc-19dc-46ba-8ae2-c6b01b9ee586)

- **Response Body**
![03_GET_findByMemberId](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/9cfd8947-e85e-45f3-8e49-75d67b07f2fc)

</details>

<details>
<summary>AH-MEMBER-004</summary>

- **Request Header**
![04_Request_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/d3a4da21-d87b-4662-b2ff-df8ae07e152d)

- **Response Header**
![04_Response_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/1cc6b4bf-1858-465e-972a-d02889ccfd27)

- **Response Body**
![04_GET_findMyProfile](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/317232ae-f488-482b-a33c-5fffc97a3e75)

</details>

<details>
<summary>AH-MEMBER-005</summary>

- **Request Header**
![05_Request_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/9129642f-e650-4bb5-885a-b43584af56bc)

- **Response Header**
![05_Response_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/04e900fb-0288-410d-96fe-2e4e657f57f6)

- **Request Body**
- **Response Body**
![05_POST_registMember](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/cb3486d0-dce1-42c8-8f55-62536fb6478f)

</details>

<details>
<summary>AH-MEMBER-006</summary>

- **Request Header**
![06_Request_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/3afe8b34-5217-4beb-bc8f-c9bb4587cfa4)

- **Response Header**
![06_Response_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/aa3c3e0c-07df-496c-86fb-7f2da5b5e431)

- **Request Body**
- **Response Body**
![06_POST_login](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/9f419f39-e775-4826-be44-a65a42316c01)

</details>

<details>
<summary>AH-MEMBER-007</summary>

- **Request Header**
![07_Request_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/bdfcaf0c-1c21-478e-9928-a5cf7f61ec53)

- **Response Header**
![07_Response_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/8c2c4fbe-0729-440a-9a15-baa25bf11a95)

- **Request Body**
- **Response Body**
![07_PUT_modifyMember](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/241f819c-efb9-4dc8-9449-4f84e70155ed)

</details>

<details>
<summary>AH-MEMBER-008</summary>

- **Request Header**
![08_Request_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/2e512694-5e7d-46e7-81d8-0c70e4f7542b)

- **Response Header**
![08_Response_Header](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/882c5d3e-2d97-4ff8-b6f3-8864f6f60cb3)

- **Request Body**
- **Response Body**
![08_DELETE_removeMember](https://github.com/4jo-Phoenix/Alcohol_hub/assets/87284220/c7c7a4f3-c8a5-48ab-9d61-bceb8f47def2)

</details>

---

- **REST-API(Fair) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/0f71d094-9f14-4d18-b2c4-6bffc27a0fe6)

<details>
<summary>AH-FAIR-001</summary>

- **Request Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/30153165-0355-4ab3-bae6-730185418208)


- **Request Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/ae39714f-9659-444a-a112-170787e5749e)


- **Response Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/f6bd9ff2-784f-4b27-8e07-b08c20295942)


- **Response Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/03d827fc-c29b-4dc8-be61-fc257fa2b589)

</details>

<details>
<summary>AH-FAIR-002</summary>

- **Request Header**
  ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/ad72323f-d508-4905-8924-2fbaba854a50)

- **Request Body**
  ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/afc95fa2-15cf-4fcf-b99a-344dba8230a3)

- **Response Header**
  ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/b4018011-2822-4742-b5d5-3ea324a92ed0)

- **Response Body**
  ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/d6924870-6c7d-4dd5-a9a4-02d2ad27b65d)


</details>

<details>
<summary>AH-FAIR-003</summary>

- **Request Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/5c68e1e5-f237-4845-b3bf-67e1cf556e02)


- **Request Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/7eb39173-01f4-4fb9-8810-4c45aa230c04)


- **Response Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/c69ea215-f0e8-43e5-9fdf-6c7aecbfa693)


- **Response Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/c37e0b4d-6443-4528-ace9-97ec0558e200)


</details>

<details>
<summary>AH-FAIR-004</summary>

- **Request Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/2abfb133-032e-4806-a3d7-da70e3dd9526)


- **Request Body**
<br> none


- **Response Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/2a7d7ecb-0f0f-44e2-a664-a50b42ba3ded)


- **Response Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/666727c0-ad43-473b-9694-ca7282ce2169)

</details>

<details>
<summary>AH-FAIR-005</summary>

- **Request Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/e94b8408-35e9-49d0-b89b-d5bca4bac090)


- **Request Body**
<br> none

- **Response Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/a3a2388d-6e78-4c38-bb5c-ceb4452d4528)


- **Response Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/40ca06d6-0685-481e-b5fe-ead7f32f121d)

</details>

---
- **REST-API(Reply) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/98ac8233-b938-4478-80ef-bad54df8c156)


<details>
<summary>AH-REPLY-001</summary>

- **Request Header**
  
![스크린샷 2024-03-10 오후 7 32 41](https://github.com/dongh810/alcohol_test/assets/105986200/d68c85e2-ab63-412e-bcaf-f5893d045686)


- **Request Body**
<br> none


- **Response Header**
  
![스크린샷 2024-03-10 오후 7 33 03](https://github.com/dongh810/alcohol_test/assets/105986200/c43c3763-91c8-4b6c-a80e-5e42a4545d14)


- **Response Body**
  
![스크린샷 2024-03-10 오후 7 33 18](https://github.com/dongh810/alcohol_test/assets/105986200/3d6ba0df-f559-4ca0-b2ee-27461c5e292c)

</details>

<details>
<summary>AH-REPLY-002</summary>

- **Request Header**
  
![스크린샷 2024-03-10 오후 7 33 37](https://github.com/dongh810/alcohol_test/assets/105986200/32a3eed9-d496-45b0-9a6d-9c7453df93ce)


- **Request Body**
<br> none


- **Response Header**
  
![스크린샷 2024-03-10 오후 7 33 50](https://github.com/dongh810/alcohol_test/assets/105986200/481b4f58-5779-43d3-9c19-57ba1d188231)


- **Response Body**
  
![스크린샷 2024-03-10 오후 7 34 06](https://github.com/dongh810/alcohol_test/assets/105986200/19d58123-6bde-4cdc-bd7a-8a198043dd79)

</details>

<details>
<summary>AH-REPLY-003</summary>

- **Request Header**
  
![스크린샷 2024-03-10 오후 7 34 19](https://github.com/dongh810/alcohol_test/assets/105986200/b04891e9-4d4b-411d-8d4e-2b906944106e)


- **Request Body**
<br> none


- **Response Header**
  
![스크린샷 2024-03-10 오후 7 34 33](https://github.com/dongh810/alcohol_test/assets/105986200/0e580ff0-b97c-43a6-a8ce-33556e1a386a)


- **Response Body**
  
![스크린샷 2024-03-10 오후 7 34 49](https://github.com/dongh810/alcohol_test/assets/105986200/46eb40bf-ed56-4743-92ef-21f1f6b890ee)

</details>

<details>
<summary>AH-REPLY-004</summary>

- **Request Header**
  
![스크린샷 2024-03-10 오후 7 35 03](https://github.com/dongh810/alcohol_test/assets/105986200/17bdcc81-bc7e-4202-b806-b23584a00757)


- **Request Body**

![스크린샷 2024-03-10 오후 7 35 10](https://github.com/dongh810/alcohol_test/assets/105986200/fe42e9bc-c6cf-43f7-a78a-1434d4d64f9c)


- **Response Header**
  
![스크린샷 2024-03-10 오후 7 35 21](https://github.com/dongh810/alcohol_test/assets/105986200/29067157-c626-46f4-b53f-f8c7e89575e2)


- **Response Body**
  
![스크린샷 2024-03-10 오후 7 35 33](https://github.com/dongh810/alcohol_test/assets/105986200/492ffccd-8159-4a35-a935-0e6259654131)

</details>

<details>
<summary>AH-REPLY-005</summary>

- **Request Header**

![스크린샷 2024-03-10 오후 7 35 52](https://github.com/dongh810/alcohol_test/assets/105986200/73c807be-e629-4fe4-a0b9-ae601a99f850)


- **Request Body**

![스크린샷 2024-03-10 오후 7 35 44](https://github.com/dongh810/alcohol_test/assets/105986200/0db0c353-cfe0-45b9-ab76-8907879f0085)


- **Response Header**
  
![스크린샷 2024-03-10 오후 7 36 06](https://github.com/dongh810/alcohol_test/assets/105986200/a15a52c2-2991-4fa8-823e-eca044be5a7d)


- **Response Body**
  
![스크린샷 2024-03-10 오후 7 36 01](https://github.com/dongh810/alcohol_test/assets/105986200/ba907070-e64a-4389-bf6c-2a4d6153044d)

</details>

<details>
<summary>AH-REPLY-006</summary>

- **Request Header**
  
![스크린샷 2024-03-10 오후 7 36 20](https://github.com/dongh810/alcohol_test/assets/105986200/7f5c1e33-2f89-43f7-9477-c3c097328409)


- **Request Body**
<br>none


- **Response Header**
  
![스크린샷 2024-03-10 오후 7 36 33](https://github.com/dongh810/alcohol_test/assets/105986200/617b4f69-52c7-4694-8efb-8289a623c560)


- **Response Body**
  
![스크린샷 2024-03-10 오후 7 36 40](https://github.com/dongh810/alcohol_test/assets/105986200/44ec18e6-0599-4ae5-b475-ba0685db70b1)

</details>

<details>
<summary>AH-REPLY-007</summary>

- **Request Header**
  
![스크린샷 2024-03-10 오후 7 36 49](https://github.com/dongh810/alcohol_test/assets/105986200/f3ecb25a-ba4f-4bf8-8790-c6387ed0a2d7)


- **Request Body**
<br>none


- **Response Header**
  
![스크린샷 2024-03-10 오후 7 37 03](https://github.com/dongh810/alcohol_test/assets/105986200/3f0e78a8-973a-413f-9848-604fb64a15e6)


- **Response Body**
  
![스크린샷 2024-03-10 오후 7 36 58](https://github.com/dongh810/alcohol_test/assets/105986200/b260c286-f23c-43f3-a01b-648597f752ee)

</details>

---
- **REST-API(Post) Definition Table**
![api](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/15eacdf6-b432-4fbf-93fc-dfa0ffab62bf)

<details>
<summary>AH-POST-001</summary>

- **Request Header**
  
![01_1Request H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/660c5152-8db5-4ebf-b335-ccf694d72843)


- **Request Body**
<br> none


- **Response Header**
  
![01_3Response H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/3e6b273b-642d-4f39-8476-e009115146c7)


- **Response Body**
  
![01_2Response B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/0da7ef4e-8266-4621-b4f0-736c8b1a1b97)

</details>

<details>
<summary>AH-POST-002</summary>

- **Request Header**
  
![02_1Request H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/5ea589f6-1431-44c9-9c4c-808e66fc6104)


- **Request Body**
<br> none


- **Response Header**
  
![02_3Response H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/cc2181db-f757-4d24-a08d-202d00b2a373)


- **Response Body**
  
![02_2Response B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/35141f6a-8c6a-4752-9564-42bc2ab325a2)

</details>

<details>
<summary>AH-POST-003</summary>

- **Request Header**
  
![03_1Request H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/013e56bf-611b-4495-91a1-e5d30fdd2de1)


- **Request Body**
<br> none


- **Response Header**
  
![03_3Response H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/5cdac815-bbc2-4d0d-8892-7afbe0f2849a)


- **Response Body**
  
![03_2Response B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/cee669f3-0aee-4d6a-a138-d4a229494397)

</details>

<details>
<summary>AH-POST-004</summary>

- **Request Header**
  
![04_1Request H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/44136d2d-bd8c-4605-b639-061fc515d79f)


- **Request Body**
<br> none


- **Response Header**
  
![04_3Response H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/3d7c3f83-183d-4ff1-a467-14158c59eca9)


- **Response Body**
  
![04_2Response B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/55cb7ebe-1fd3-498b-936a-68dde5432197)

</details>

<details>
<summary>AH-POST-005</summary>

- **Request Header**
  
![05_1Request H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/1a25d6ba-f13d-4510-b0be-2c3e2a3ebd30)


- **Request Body**
![05_2Request B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/ba99fe81-670e-47a1-a769-b62143894139)


- **Response Header**
  
![05_4Response H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/f6db568f-a75c-46ae-bf71-43280e361760)


- **Response Body**
  
![05_3Response B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/3a0ee014-5851-4879-a652-a50d1aba65a4)

</details>

<details>
<summary>AH-POST-006</summary>

- **Request Header**
  
![06_1Request H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/721027b1-b9ff-43b6-a59b-83d85b6b2736)


- **Request Body**
<br> none


- **Response Header**

![06_3Response H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/a233e116-a748-4683-8541-4e394a880148)


- **Response Body**
  
![06_2Response B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/c9821f58-6323-4d1d-ad91-7ecf12bc8555)

</details>

<details>
<summary>AH-POST-007</summary>

- **Request Header**
  
![07_1Request H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/e94128ae-b654-407f-8e74-dedf00c2786c)


- **Request Body**
![07_2Request B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/ecaab777-9092-4dac-9db5-e529521c49d2)


- **Response Header**

![07_4Response H](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/8e48d169-4bf5-4411-98c9-7383125660b9)


- **Response Body**
  
![07_3Response B](https://github.com/4jo-Phoenix/Alcohol_hub/assets/153909291/b82d6892-e24e-4a65-af09-3fd8ec8ae5c0)

</details>

---
- **REST-API(News) Definition Table**
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/113569573/1f58f7c5-84bd-4774-8fcc-ae6d37291607)


<details>
<summary>AH-News-001</summary>

- **Request Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/30153165-0355-4ab3-bae6-730185418208)


- **Request Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/ae39714f-9659-444a-a112-170787e5749e)


- **Response Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/f6bd9ff2-784f-4b27-8e07-b08c20295942)


- **Response Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/03d827fc-c29b-4dc8-be61-fc257fa2b589)

</details>

<details>
<summary>AH-News-002</summary>

- **Request Header**
  ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/ad72323f-d508-4905-8924-2fbaba854a50)

- **Request Body**
  ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/afc95fa2-15cf-4fcf-b99a-344dba8230a3)

- **Response Header**
  ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/b4018011-2822-4742-b5d5-3ea324a92ed0)

- **Response Body**
  ![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/d6924870-6c7d-4dd5-a9a4-02d2ad27b65d)


</details>

<details>
<summary>AH-News-003</summary>

- **Request Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/5c68e1e5-f237-4845-b3bf-67e1cf556e02)


- **Request Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/7eb39173-01f4-4fb9-8810-4c45aa230c04)


- **Response Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/c69ea215-f0e8-43e5-9fdf-6c7aecbfa693)


- **Response Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/108782390/c37e0b4d-6443-4528-ace9-97ec0558e200)


</details>

<details>
<summary>AH-News-004</summary>

- **Request Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/113569573/0e0e06f8-8515-47dc-8e20-89b96490a9e1)



- **Request Body**
<br> none


- **Response Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/113569573/8583dbbc-8ca4-4c8e-9d28-6a15e5c6f835)



- **Response Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/113569573/6f1fcedc-c4c2-4fe0-b8fc-8f6bd8bc01ff)


</details>

<details>
<summary>AH-News-005</summary>

- **Request Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/113569573/f83c235a-71c7-4bf8-a344-12d5615258c4)



- **Request Body**
<br> none

- **Response Header**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/113569573/f0b8c199-5a33-4226-a2bc-bf227460b9ab)



- **Response Body**
  
![image](https://github.com/4jo-Phoenix/Alcohol_hub/assets/113569573/11ec875c-08f8-4c67-af2f-5a1e0952cc81)


</details>

---

- **REST-API(News) Definition Table**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/a346e044-24a1-41b7-bff2-12b22090ff67)

<details>
<summary>AH-NEWS-001</summary>

- **Request Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/2d927184-72dc-47b2-9e73-23cffa972532)

- **Request Body**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/c5ebd1b1-d2ef-41bb-a6a2-d469dde2d5c7)

- **Response Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/bd430bf4-a28b-4860-b378-54118eec7866)

- **Response Body**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/50ccc6b9-59ad-4e82-8c2d-c774eb8eb266)

</details>

<details>
<summary>AH-NEWS-002</summary>

- **Request Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/33d7edbf-2911-4c96-8e6b-abf1212cdf96)

- **Request Body**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/1ee92c23-78d2-4134-a743-f67f78fed6cb)

- **Response Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/20bbe6b1-eb44-41ef-8972-a0484baa242d)

- **Response Body**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/6b0affa0-b2df-481e-a639-295957249b54)


</details>

<details>
<summary>AH-NEWS-003</summary>

- **Request Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/2278bc58-5e2f-41b5-baf6-54f1d037f2c5)


- **Request Body**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/fde64076-41ad-46a9-919e-9eefeb4feef2)


- **Response Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/6a6f7878-ef18-481c-b6a7-67d3331c78ab)


- **Response Body**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/3eff8be9-4ed2-4541-8224-23bc4dc6e4e5)

</details>

<details>
<summary>AH-NEWS-004</summary>

- **Request Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/93a0c4f9-4dd0-4352-a9df-14f12305d361)


- **Request Body**
<br> none

- **Response Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/b0647994-f8ba-4a12-918a-10f97cb02c66)


- **Response Body**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/c7a07d44-542f-4849-aa46-228436b99742)

</details>

<details>
<summary>AH-NEWS-005</summary>

- **Request Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/ddb28564-3c7e-467a-baa8-cf5809966854)

- **Request Body**
<br> none

- **Response Header**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/9d737e4b-7791-4512-8065-57eca5f90246)

- **Response Body**
![image](https://github.com/beyond-sw-camp/be04-2nd-4team-ahub/assets/108782390/953ba93a-d427-482c-bc3c-cc7dea1d7d42)

</details>

<br>

# 5. 프로젝트 회고

- **백동현** :  이번 프로젝트는 DB프로젝트때보다 더힘들었던 것 같습니다. 서버를 만든다는 것 자체가 굉장히 어려워서 공부하고 코드를 짜는데도 시간이 훨씬 오래걸린것 같고,프로젝트를 진행하면서도 이게맞나? 라는 의심이 굉장히 많이 들었던 것 같습니다. 하지만 팀원들과 함께 서로 모르는것을 물어보고 도움을 받아가며 프로젝트를 진행하다보니 어느순간 프로젝트가 완성된 것을 볼 수 있었습니다. 이렇게 만들어놓은 서버를 가지고 앞으로 프론트부분까지 만들것을 생각하니 기대가 되고 앞으로 더 열심히 해야겠다고 느꼈습니다.

- **손세림** : 해당 프로젝트를 통해 부족한 부분을 파악하고 개선해나갈 수 있는 시간이었습니다.  
  먼저, 전반적인 개발 과정에 대해 파악할 수 있었습니다. 아이디어 기획부터 DDD 설계, DB 구축까지 고려하여 원하는 서비스를 개발하기 위해 필요한 기능과, 기능 구현에 필요한 정보들이 무엇이 있을지 팀원들과 함께 회의하며 파악할 수 있었습니다. 또한 이 과정을 통해서 서비스 하나를 개발하기 위해 어떠한 것들을 고려해야 하는지 알 수 있었습니다.  
  둘째로, 이번 프로젝트를 통해 수업에서 배웠지만 체감되지 않던 내용들을 확실히 이해할 수 있었습니다. mybatis와 JPA 등 백엔드에서 DB와 연동하는 다양한 데이터 전달 방법과 컨트롤러, 서비스, Repository와 같은 계층간의 관계를 직접 구현하고 사용해보며 사용함으로써 지식을 체득할 수 있었습니다.  
  또한 에러를 해결하는 능력을 향상시킬 수 있었습니다. 이전 프로젝트와 달리 규모가 커진만큼 기능을 구현하는 과정에서 정말 많은 에러가 발생하였습니다. 프로젝트 초반에는 에러가 발생한 이유를 찾는 것조차 쉽지 않아 하나하나 기능을 구현 할 때마다 오랜 시간이 소요되었습니다. 하지만 발생한 문제들을 팀원분들께 공유하고 조언을 구함으로써 에러를 해결하는 방식과 해당 에러가 발생하는 이유가 무엇인지 파악하는 방법을 익히게 되었고 이런 저런 시도를 해보며 해결하는 과정에서 보람과 재미를 느낄 수 있었습니다.  
  예상보다 촉박한 일정에 힘들기도 하였지만 다들 열심히 임해주시고 도움을 주었던 팀원분들께 정말 감사한 시간이였습니다. 아직은 원하는 기능을 척척 구현할 만큼 대단한 실력을 갖추지는 못했지만, 아쉬움이 남는 만큼 여기서 끝내지 않고 이번 프로젝트를 고도화하며 다양한 시도를 통해 점차 실력을 향상시키는 것이 저의 목표입니다.  

- **송동준** : 2차 프로젝트에서는 실제 개발 과정이랑 비슷한 느낌으로 말로만 들었던 백엔드를 통하여 실제 서버를 만든다는 점에서 의미가 깊은 프로젝트였던 거 같다 1차 프로젝트에 비해 방대한 양의 지식을 다루기에 따라가기는 힘들었으나 팀원들이 많은 도움을 주셔서 많은 것을 배우고 성장해 나가면서 무사히 프로젝트를 마칠 수 있었다. 다음 프런트 프로젝트는 미리미리 준비해나가며 더욱 열심히 하여 팀원들한테 더욱 도움이 될 수 있도록 노력하고 더욱더 만족스러운 결과를 얻기 위해 노력해야겠다.

- **양지혜** : 서버를 고려하여 개발한다는 점이 굉장히 어렵게 다가왔습니다. 또한 프로그래밍 언어에 서툴어 팀원들에게 많은 도움을 받았습니다. 저는 다른 욕심보다는 이 프로젝트에서 1인분을 하고자 노력하였습니다. 기능 구현 등을 좀 더 공부하여 해당 프로젝트를 고도화하고 싶습니다. 어제보다 오늘 더 노력하여 팀에서 필요한 역할을 할 수 있는 팀원이 되고자 노력하겠습니다.

- **정태원** : 본격적으로 프로그래밍 언어를 사용하여 프로젝트를 만드는 것은 처음이라 굉장히 긴장했던 프로젝트 였습니다. 하지만 모두가 힘든 와중에도 누구하나 포기하지 않고 더 힘든 팀원을 도와 주어서 만족할만한 결과물이 나올 수 있었다고 생각합니다. 앞으로 프론트 엔드 서버까지 생성하며 진짜 웹 사이트를 만들 수 있을텐데, 현재의 결과물에 만족하지 않고 계속 고도화 시켜 나가며 프론트 프로젝트까지 쭉 좋은 결과를 이어갈 수 있으면 좋겠습니다. 






