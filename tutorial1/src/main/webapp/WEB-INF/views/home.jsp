<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Spring MVC and List Example</h2>

<p>"${categories}"</p>
		<ul>
			<c:forEach var="category" items="${categories}">
				<li>${category}</li>
			</c:forEach>
		</ul>
</body>
</html>