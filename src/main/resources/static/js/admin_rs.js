function checkDuplicateId() {
    let userId = $('#userId').val();
    $.ajax({
        url: "/checkDuplicateId",
        type: "POST",
        data: {user_id: userId},
        success: function (response) {
            if (response == "exist") {
                $('#idCheckMessage').text("이미 사용중인 아이디입니다.");
            } else {
                $('#idCheckMessage').text("사용 가능한 아이디입니다.");
            }
        }
    });
}
$(document).ready(function() {
    $.ajax({
        type : "POST",
        url : "/ajax",
        success : function(data) {
            // Ajax Response 값 활용하여 View 갱신
            $("#result").html(data);
        },
        error : function(e) {
            alert('Error: ' + e);
        }
    });
});



    function loadDocArray() {
    const xhttp = new XMLHttpRequest();

    xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
    const  myAjax = JSON.parse(this.responseText)
    console.log(myAjax);

    // json data를 내가 만들었던 테이블 형태로 넣기
    let ajaxTD ="";
    ajaxTD += '<tr id="tr_loop" className="tr_td">';
    ajaxTD += '<td>'+myAjax.user_id+'</td>';
    ajaxTD += '<td >'+myAjax.user_pass+'</td>';
    ajaxTD += '<td >'+myAjax.user_name+'</td>';
    ajaxTD += '<td >'+myAjax.user_email+'</td>';
    ajaxTD +=   '<td >'+myAjax.user_tel+'</td>';
    ajaxTD +=   '<td >'+myAjax.zip_code+'</td>';
    ajaxTD +=   '<td >'+myAjax.address1+'</td>';
    ajaxTD += '<td >'+myAjax.address2+'</td>';
    ajaxTD += '<td >'+myAjax.address3+'</td>';
    ajaxTD +=   '<td >'+myAjax.address4+'</td>';
    ajaxTD +=  '<td >'+myAjax.user_point+'</td>';
    ajaxTD += '</tr>';


    document.getElementById("t_body").innerHTML = ajaxTD;
}
};
    xhttp.open("GET", "/txt/ajax_info.txt");
    xhttp.send();
}

// Ajax test 활용 : https://www.w3schools.com/js/tryit.asp?filename=tryjs_ajax_onreadystage
