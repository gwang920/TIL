$(document).ready(function() {
  $('#movetopbt').bind('click', function() {
    $('html, body').animate({scrollTop: '0'}, 680);
  });
  // 애니메이션 효과로 자연스럽게 이동됨, 0.68초

  $('#btn_join').on('click', function() {
    $('index.jsp').scrollTop('');
  });
  // 애니메이션 효과없이 즉시 해당 위치 0 지점으로 이동함
});