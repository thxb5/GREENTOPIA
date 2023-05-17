document.addEventListener('DOMContentLoaded', function(){
    const remain_point = document.querySelector('[name=remain_point]').value;

    const button = document.querySelector('#button3');

    button.addEventListener("click", function(e){
        if(!confirm('정말로 결제하시겠습니까?')){
            alert("취소되었습니다");
            e.preventDefault();
        }
        else{
            if(remain_point < 0){
                e.preventDefault();
                alert('결제해야할 포인트가 현재 보유 포인트보다 많습니다');
            }
            else {
            }
        }
    })

});