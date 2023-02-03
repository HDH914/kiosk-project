const uri = location.href;
const id = uri.substring(uri.lastIndexOf("/") + 1);
const menuInfoArea = document.querySelector(".menu-info-area");
const memoInfoArea = document.querySelector(".menu-memo-area");


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

function menuInfo(responseData) {
    menuInfoArea.innerHTML = `
    <!-- 메뉴 이미지 -->
                <div class="image-area">
                    <form class="image-form" enctype="multipart/form-data">
                        <div class="image-title">
                            <span>상품 이미지</span>
                        </div>
                        <div class="image">
                            <img src="/static/images/noImage.jpg" alt="no-image">
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
                            <option value="">카테고리를 선택해주세요.</option>
                            <option value="2">시즌</option>
                            <option value="3">커피</option>
                            <option value="4">음료</option>
                            <option value="5">티</option>
                            <option value="6">디저트</option>
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