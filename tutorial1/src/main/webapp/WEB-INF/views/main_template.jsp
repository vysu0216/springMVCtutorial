<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<body>
    <div class="page">
        <tiles:insertAttribute name="title" />
        <div class="content">
            <tiles:insertAttribute name="menu" />
            <tiles:insertAttribute name="body" />
        </div>
    </div>
</body>