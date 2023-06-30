document.addEventListener("DOMContentLoaded", () => {
  const list_table = document.querySelector("table.main.list");

  // table 의 tr을 클릭했을때 사용할 event
  const trClickHander = (e) => {
    // table > tr 을 클릭했을때 최종적으로 클릭 되는 요소는 TD이다.
    // 최종적으로 클릭되는 요소를 e.target 이라고 한다.
    const td = e.target;
    if (td.tagName === "TD") {
      // td.closet
      // td를 감싸고 있는 TR중에서 가장 가까운 tag
      const tr = td.closest("TR");
      // data-id 속성에 설정된 값을 가져오기
      const id = tr.dataset.id;
      document.location.href = `${rootPath}/detail?id=${id}`;
    }
  };

  list_table.addEventListener("click", trClickHander);
});
