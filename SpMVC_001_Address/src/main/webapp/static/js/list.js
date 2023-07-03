/**
 < 이벤트 버블링을 역 이용한 이벤트 핸들링 간소화 하기. >
 List 화면에서 항목을 클릭 했을때, Detail 주소 정보를 보여주는 
 화면으로 화면전환을 하려고 한다. 

 사용자가 List 의 어딘가를 클릭하면 그 클릭한 event 를 설정해야 한다. 
 List 에서 최종적으로 클릭되는 요소는 Table > Tr > Td 에서 TD 요소가 된다.
 현재 화면에 10명의 주소가 보이고 있는데, 이 화면의 TD 요소에 
 이벤트 핸들링을 수행하려면 40 개의 이벤트를 설정 해야 한다.

 이러한 방식은 코드 작성이 어렵진 않으나,
 실제 작동되는 과정은 많은 문제를 일으 킬 수 있다.

 JS 에서 querySelectAll()을 사용하여 만든 List 에 event 핸들링을 설정하는 것은 
 매우 불합리한 코드가 될 수 있다.

 이럴때는 querySelectAll()을 사용해야 하는 tag 들을 감싸고 있는 
 부모 tag를 살펴야 한다. 어떤 부모 tag에 event 핸들링을 설정하면 가장 작은 개수의 event 핸들링을 
 설정 할수 있을지 고민해야 한다. 

 여기에서는 table 자체에 event 핸들링을 설정 하였다. 
 event 코드 내에서 최종 적으로 어떤 tag가 선택(click)되는지 살피고 
 그 tag 가 클릭 되었을때 실제 필요한 코드르 작성한다. 
 * 
 */

document.addEventListener("DOMContentLoaded", () => {
  // td 클릭이벤트는 총 '40'개가 설정된다.
  // const tdList = document.querySelectorAll("table.main td");
  // for (let i = 0; i < tdList.length; i++) {
  //   tdList[i].addEventListener("click", (e) => {
  //     //td를 클릭 햇을때 수행할 event 코드들.
  //   });
  // }

  // table을 Select 하고
  const list_table = document.querySelector("table.main.list");

  // table을 클릭 할때 사용할 event핸들러
  // 실제로는 table > tr > td가 클릭되는 것으 감지하여 코드 실행.
  const trClickHander = (e) => {
    // table을 클릭했을때 최종적으로 클릭 되는 요소는 TD 이다.
    // 최종적으로 클릭되는 요소를 e.target 이라고 한다.
    const td = e.target;
    // 최종적으로 클릭된 요소가 TD 인가 를 확인하고
    if (td.tagName === "TD") {
      // td.closet
      // td를 감싸고 있는 TR중에서 가장 가까운 부모tag가 무엇이냐?
      const tr = td.closest("TR");
      // tr 의 data-id 속성에 설정된 값을 가져오기
      const id = tr.dataset.id;
      document.location.href = `${rootPath}/detail?id=${id}`;
    }
  };

  list_table?.addEventListener("click", trClickHander);
});
