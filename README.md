# Elaticsearch를 이용한 네이버 댓글수사대 입니다.
사용한 기술 스택은 Spring boot와 Elasticsearch를 활용하였습니다.

실행 방식은 Spring boot서버를 실행시키고 ES에 뉴스 댓글들을 적재하면 됩니다.

클라이언트를 통해 서버로 유사도를 검색하고 싶은 댓글을 보내면

유사도의 정도를 비교하여 유사한 댓글을 보내주며 서비스 운영자가 사전에 설정한 것 이상의

유사도를 가지는 댓글은 다른 색으로 표시 해 줍니다.

![image](https://user-images.githubusercontent.com/45382126/99761294-13306100-2b39-11eb-93e1-31b95ba10224.png)
