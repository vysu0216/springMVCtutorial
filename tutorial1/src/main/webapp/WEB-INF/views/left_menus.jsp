<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h2>All categories:</h2>
		<ul>
			<c:forEach var="category" items="${categories}">
				<li>${category.name}</li>
			</c:forEach>
		</ul>
</body>