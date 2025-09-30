package org.example.board.util;

import org.springframework.stereotype.Service;

@Service
public class MyUtil {

    //numPerPage = 한 페이지당 글 수
    // dataCount = 전체 글 수
    // numPerBlock = 한 화면에 표시할 페이지 번호 개수 예: numPerBlock = 5 라고하면 1~ 5, 6 ~ 10 , 11~15
    // currentPageSetup 현재 페이지가 속한 블록의 시작점 -1 = 이전 블록의 마지막 페이지 번호
    // page 실제 출력할 페이지 번호

    // 전체 페이지
    public int getPageCount(int numPerPage, int dataCount) {
        // num = 한페이지당 글 수 , data = 전체 글 수
        int pageCount = 0;

        pageCount = dataCount / numPerPage;
        if (dataCount % numPerPage != 0) { // 나머지가 있으면 페이지 하나더 추가
            pageCount++;

        }
        return pageCount;
    }

    //페이지 처리 메서드
    // currentPage : 현재 표시할 페이지  /  totalPage : 전체 페이지 수
    // listUrl : 링크를 설정할 url(list.jsp)
    public String pageIndexList(int currentPage, int totalPage, String listUrl) {
        int numPerBlock = 5; //표시할 페이지 ◀이전 6 7 8 9 10 다음▶
        int currentPageSetup; // ◀에 들어가있는 값 , 표시할 첫 페이지에 -1 해준 값
        int page; // 6 7 8 9 10 -> 하이퍼링크가 될 page index 숫자

        StringBuffer sb = new StringBuffer();

        // 데이터가 없을 때
        if (currentPage == 0 || totalPage == 0) {
            return ""; //null값줌
        }
        // list.jsp?pageNum=2
        // list.jsp?searchKey=subject&searchValue=aa&pageNum=2
        // URL에 이미 파라미터가 있는지 확인
        //? 있으면 뒤에 & 붙임 → list.jsp?searchKey=subject&
        //없으면 ? 붙임 → list.jsp?
        if (listUrl.indexOf("?") != -1) {
            listUrl = listUrl + "&";
        } else {
            listUrl = listUrl + "?";
        }

        // 1 2 3 4 5 다음▶
        // ◀이전 6 7 8 9 10 다음▶
        // ◀이전 11 12 13 14 15 다음▶
        // 시작 위치 계산
        currentPageSetup = (currentPage / numPerBlock) * numPerBlock;

        if (currentPage % numPerBlock == 0) {
            // 현재 페이지가 블록의 마지막 페이지일 때, 블록 시작을 조정
            currentPageSetup = currentPageSetup - numPerBlock;
        }

        // ◀이전
        if (totalPage > numPerBlock && currentPageSetup > 0) {
            //현재 블록 앞에 다른 블록이 있으면 ◀이전 링크 생성.
            sb.append("<a href=\"" + listUrl + "page=" + currentPageSetup + "\">◀이전</a>&nbsp;");
        }

        //바로가기 페이지 (6 7 8 9 10)
        // 블록의 첫 페이지부터 시작
        page = currentPageSetup + 1;
        // 블록 범위 안에서 페이지 번호를 출력
        while (page <= totalPage && page <= (currentPageSetup + numPerBlock)) {
            //파이퍼링크
            if (page == currentPage) {
                sb.append("<font color=\"Fuchsia\">" + page + "</font>&nbsp;");
                // <font color="Fuchsia">9</font>
            } else {
                sb.append("<a href=\"" + listUrl + "page=" + page + "\">" + page + "</a>&nbsp;");
                // <a href="list.jsp?pageNum=7">7</a>&nbsp;
            }

            page++;
        }
        // 다음▶
        // ◀이전 6 7 8 9 10 다음▶
        // ◀이전 11 12
        if (totalPage - currentPageSetup > numPerBlock) {
            sb.append("<a href=\"" + listUrl + "page=" + page + "\">다음▶</a>&nbsp;");
            // <a href="list.jsp?pageNum=11;>다음▶</a>&nbsp;
        }
        return sb.toString();
    }
}
