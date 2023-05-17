document.addEventListener('DOMContentLoaded', function(){
    const enroll = document.querySelector('#productEnroll');

    enroll.addEventListener("click", function(e){
        if(!confirm('등록하시겠습니까?')){
            e.preventDefault();
            alert("취소 되었습니다");
            history.back();
        }
        else{
            alert("등록되었습니다.");
        }

    });

})



