function checkUserId() {
    let userName = $('#id_name').val();
    let userEmail = $('#id_email').val();
    $.ajax({
        url: "/checkUserId",
        type: "POST",
        data: {user_name: userName, user_email: userEmail},
        success: function (response) {
            if (response && response.user_id) {
                $('#idCheckMessage').text("회원님의 아이디는 " + response.user_id + "입니다.");
            } else {
                $('#idCheckMessage').text("해당 사용자의 아이디가 존재하지 않습니다.");
            }
        },
        error: function () {
            $('#idCheckMessage').text("요청에 실패하였습니다.");
        }
    });
}

function checkUserPass() {
    let userName = $('#pass_name').val();
    let userId = $('#pass_id').val();
    let userEmail = $('#pass_email').val();
    $.ajax({
        url: "/checkUserPass",
        type: "POST",
        data: {user_name: userName, user_id: userId ,user_email: userEmail},
        success: function (response) {
            if (response == "exist") {
                $('#passCheckMessage').text("해당되는 회원님의 이메일로 번호를 발송했습니다.");
            } else {
                $('#passCheckMessage').text("해당 정보에 해당하는 아이디가 존재하지 않습니다, 다시 확인해주십시오.");
            }
        },
        error: function () {
            $('#passCheckMessage').text("요청에 실패하였습니다.");
        }
    });
}