<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <t:common-head />

    <title>Simpe Webapp ({{username}})</title>
</head>
<body>
<t:header />

<div class="content-container">
    <h1 class="username">{{username}}</h1>

    <p>
        This is your profile page. Here you can edit your account settings.
    </p>
</div>
</body>
</html>