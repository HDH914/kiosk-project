# kiosk-project

##프로젝트 설명

카페나 음식점에 갔을때 예전보다 키오스크의 사용량이 눈에띄게 많아진것을 볼 수 있습니다. 이를 통해 나만의 키오스를 만들어 보고싶다고 생각이 들어 이 프로젝트를 개발하게 되었습니다.
고객의 입장에서도 생각해보고, 관리자의 입장에서도 생각하며 만들었기 때문에 고객들도 직관적으로 메뉴를 쉽게 볼수 있고, 관리자도 관리자 페이지를 통해 CRUD 기능을 사용해 메뉴 검색, 메뉴 추가, 메뉴 수정, 메뉴 삭제를 할 수 있습니다.
처음 혼자서 만들어 본 프로젝트라 엄청나게 특별한 기능은 없지만 키오스크의 기본적인 기능들은 담겨있으므로 본인의 스타일대로 자유롭게 수정하셔서 사용해보시면 좋을것 같습니다.

##기능 설명
###유저 기능(User Service)
1 메뉴 선택
###관리자 기능(Admin Service)
1 Create
  * 관리자 페이지에서 추가하기 버튼을 클릭해 메뉴 추가하는 기능
2 Read
  * 전체적인 메뉴리스트를 출력시켜 주는 기능
  * 각각의 메뉴의 정보(메뉴이름, 카테고리, 가격, 이미지 등)을 출력시켜 주는 기능
  * 검색창에 메뉴이름이나 카테고리등을 선택하면 조건에 알맞은 정보를 출력 시켜주는 기능
3 Update
  * 메뉴의 이름을 수정할 수 있는 기능
  * 메뉴의 카테고리를 수정 할 수 있는 기능
  * 메뉴의 이미지를 수정 할 수 있는 기능
  * 메뉴의 가격을 수정 할 수 있는 기능
  * 메뉴의 비고를 수정할 수 있는 기능
4 Delete
  * 삭제하고 싶은 메뉴의 삭제 버튼을 누르면 삭제하는 기능
