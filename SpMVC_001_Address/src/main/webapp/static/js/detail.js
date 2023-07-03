document.addEventListener("DOMContentLoaded", () => {
  const btn_list = document.querySelector("button.detail.list");
  const btn_update = document.querySelector("button.detail.update");
  const btn_delete = document.querySelector("button.detail.delete");

  btn_list?.addEventListener("click", () => {
    document.location.href = `${rootPath}/`;
  });

  btn_update?.addEventListener("click", (e) => {
    const id = e.target.dataset.id;
    document.location.href = `${rootPath}/update?id=${id}`;
  });

  btn_delete?.addEventListener("click", (e) => {
    // button tag 가 가장 중앙에 있기 때문에
    // click event e.target 은 delete button 이 된다.
    const btn = e.target;
    const id = btn.dataset.id;

    if (confirm("삭제한 데이터는 복구 할 수 없습니다.\n정말 삭제 할까요?")) {
      /**
       * JS 에서 서버요청 한후 화면에 대한것
       * document.location.href = "URL"으로 요청하면
       * 현재 화면이 뒤로 밀쳐지고, 새로운 화며이 열리면서 서버의 response 내용을 보여줌.
       * 이때 브라우져의 뒤로가기를 하면 이전 내용을 볼 수 있다.
       *
       * document.location.realsce(URL) 으로 요청을 하면,
       * 현재 화면에 서버로 부터 전달 받은 화면이 겹쳐서 표현 된다.
       * 뒤로가기 화면을 없애는 효과를 낸다.
       */

      document.location.replace(`${rootPath}/delete?id=${id}`);
    }
  });
});
