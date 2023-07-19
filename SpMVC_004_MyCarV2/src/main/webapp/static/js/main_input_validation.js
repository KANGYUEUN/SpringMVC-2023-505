const err_clear = () => {
  const err_box_list = document.querySelectorAll("div_error");
  for (let box of error_box_list) {
    box.classList.remove("on");
  }
};

const err_message = (err_box, e, message) => {
  const value = e.value;
  if (!carnum) {
    err_clear();
    err_box.classList.add("on");
    err_box.innerHTML = message;
  }
};
