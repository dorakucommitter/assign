$(function() {

  $('#admin_menu').popover({
    trigger  : 'manual',  /* safariはforcusに対応してないらしい */
    placement: 'bottom',
    toggle   : 'popover',
    offset   : 10,
    animate  : false,
    html     : true,
    title    : '管理者メニュー',
    content  : '<a href="/employee">社員情報</a><br />',
    /* popoverで表示される内容のテンプレ */
    template: '<div class="popover popover-medium" style="font-size:14pt;font-weight:bold;width:240px;"><div class="arrow"></div><div class="popover-inner"><h3 class="popover-title"></h3><div class="popover-content"><p></p></div></div></div>',
    /* 何に効いてくるのか不明 */
    //container: 'body',
  }).click(function(evt) {
    evt.stopPropagation();
    $(this).popover('show');

    /* triggerにforcusを指定すると簡単だけど、safariでは無効らしいので、 */
    /* ほかのpopoverは手動で閉じる。何とか自動で閉じてくれないだべか？ */
    //$('#user_config').popover('hide');
  });


  $(document).on('click', '.popover', function(evt) {
    evt.stopPropagation();
  });

  $(document).on('click', 'html', function() {
    $('#admin_menu').popover('hide');
  });

});