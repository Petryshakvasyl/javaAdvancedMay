<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${products}" var="product">
    ${product.name}<br>
    ${product.price}<br>
</c:forEach>
