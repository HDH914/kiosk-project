const menuInfoArea = document.querySelector(".menu-info-area");
const memoInfoArea = document.querySelector(".menu-memo-area");
const saveButton = document.querySelector(".save-button");
const cancelButton = document.querySelector(".cancel-button");
const uri = location.href;
const id = uri.substring(uri.lastIndexOf("/") + 1);

// 메뉴 정보 불러오기
loadMenuInfo(id);
function loadMenuInfo(id) {
    let responseData = null;

    $.ajax({
        async: false,
        type: "get",
        url: "/api/menu/admin/modification/" + id,
        dataType: "json",
        success: (response) => {
            responseData = response.data;
            console.log(responseData);
            menuInfo(responseData);
        },
        error: (error) => {
            console.log(error);
        }
    });
}
// 불러온 메뉴정보 띄우기
function menuInfo(responseData) {
    //////////////////////////////

    // let categoryId = document.querySelectorAll(".category-value");
    // categoryId.forEach((value) => {
    //     if(categoryId.value == responseData.categoryId){
    //         categoryId
    // (selected == true)
    //     }
    // })

    /////////////////////////////////
    menuInfoArea.innerHTML = `
    <!-- 메뉴 이미지 -->
                <div class="image-area">
                    <form class="image-form" enctype="multipart/form-data">
                        <div class="image-title">
                            <span>상품 이미지</span>
                        </div>
                        <div class="image">
                            <img src="/image/menu/${responseData.menuImg.temp_name}" alt="no-image">
                        </div>
                        <input class="image-input" type="file" name="file">
                    </form>
                </div>
                <!-- 메뉴 정보 -->
                <div class="menu-detail">
                    <div class="menu-name menu-info">
                        <span>상품명</span>
                        <input class="menu-input" type="text" value="${responseData.menuName}">
                    </div>
                    <div class="menu-category menu-info">
                        <span>카테고리</span>
                        <select name="category" class="menu-input" >
                            <option class="category-value" value="">카테고리를 선택해주세요.</option>
                            <option class="category-value" value="2">시즌</option>
                            <option class="category-value" value="3">커피</option>
                            <option class="category-value" value="4">음료</option>
                            <option class="category-value" value="5">티</option>
                            <option class="category-value" value="6">디저트</option>
                        </select>
                        <!-- <input class="menu-input" type="text"> -->
                    </div>
                    <div class="menu-price menu-info">
                        <span>가격</span>
                        <input class="menu-input" type="text" value="${responseData.price}">
                    </div>
                </div>
    `
    memoInfoArea.innerHTML = `
     <div class="memo-title">
        <span>비고 사항</span>
    </div>
    <div class="memo-content">
        <textarea class="menu-memo menu-input" name="" id="" cols="30" rows="10" value="${responseData.memo}"></textarea>
    </div>
    `
}
// 수정된 메뉴 정보 저장
saveButton.onclick = () => {
    const menuInput = document.querySelectorAll(".menu-input");
    let imageInput = document.querySelector(".image-input");
    let formData = new FormData();

    formData.append("menuImg", imageInput.value);
    formData.append("menuName", menuInput[0].value);
    formData.append("categoryId", menuInput[1].value);
    formData.append("price", menuInput[2].value);
    formData.append("memo", menuInput[3].value);

    formData.forEach((value, key) => {
        console.log(key);
        console.log(value);
        console.log();
    });
    if (menuInput[1].value == 0) {
        alert("카테고리를 선택해주세요.");
    } else {
        updateMenu(formData);
    }
}

// 메뉴 수정 데이터 보내기
function updateMenu(formData) {
    $.ajax({
        async: false,
        type: "put",
        url: "/api/menu/admin/modification/update/" + id,
        enctype: "multipart/form-data",
        contentType: false,
        processData: false,
        data: formData,
        dataType: "json",
        success: (response) => {
            alert("수정 성공");
            let msg = null;
            msg = confirm("페이지에서 나가시겠습니까?");
            if (msg) {
                location.href = "/admin";
            } else {
                location.reload();
            }
        },
        error: (error) => {
            console.log(error);
            alert("수정 실패");
        }
    });
}

// 취소 버튼
cancelButton.onclick = () => {
    let msg = null;
    msg = confirm("정말로 취소하시겠습니까?");

    if (msg) {
        location.href = "/admin";
    }
}