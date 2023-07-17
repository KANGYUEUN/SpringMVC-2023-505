document.addEventListener("DOMContentLoaded", () => {
  const image_box = document.querySelector("div.image_list");
  const image_delete = (e) => {
    const btn_delete = e.target;
    if (btn_delete.tagName === "SPAN") {
      const seq = e.target.dataset.seq;
      if (confirm(`${seq} 사진을 삭제 할 까요?`)) {
        document.location.href = `${rootPath}/image_delete?seq=${seq}`;
      }
    }
  };
  image_box.addEventListener("click", image_delete);
});
