<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
    <div class="col-md-5 col-md-offset-7">
        <nav aria-label="...">
            <ul class="pagination pagination-lg">
                <c:if test="${not empty pageInfo }">
                    <li><a href="?pn=1" aria-label="Previous"><span
                            aria-hidden="true">首页</span></a></li>
                    <li><a href="?pn=${pageInfo.prePage }" aria-label="Previous"><span
                            aria-hidden="true">&laquo;</span></a></li>
                    <c:forEach items="${pageInfo.navigatepageNums }" var="i">
                        <c:if test="${pageInfo.pageNum eq i }">
                            <li class="active"><a href="?pn=${i }">${i }<span class="sr-only">(current)</span></a></li>
                        </c:if>
                        <c:if test="${pageInfo.pageNum ne i }">
                            <li><a href="?pn=${i }">${i } <span class="sr-only">(current)</span></a></li>
                        </c:if>
                    </c:forEach>

                    <c:if test="${pageInfo.hasNextPage }">
                        <li>
                            <a href="?pn=${pageInfo.nextPage }" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${pageInfo.hasNextPage eq false}">
                        <li>
                            <a href="?pn=${pageInfo.pageNum }" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </c:if>
                    <li><a href="?pn=${pageInfo.pages }" aria-label="Previous"><span
                            aria-hidden="true">尾页</span></a></li>
                </c:if>
            </ul>
        </nav>
    </div>
</div>