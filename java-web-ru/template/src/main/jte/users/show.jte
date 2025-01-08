@import exercise.dto.users.UserPage
@param UserPage userPage
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
          crossorigin="anonymous">
    <title>User</title>
</head>
<body>
<div class="mx-auto p-4 py-md-5">
    <main>
        <table border="1" cellspacing="0" cellpadding="8">
            <tr>
                <th>Id</th>
                <th>First name</th>
                <th>Last name</th>
                <th>E-mail</th>
            </tr>
            <tr>
                <td>${userPage.getUser().getId()}</td>
                <td>${userPage.getUser().getFirstName()}</td>
                <td>${userPage.getUser().getLastName()}</td>
                <td>${userPage.getUser().getEmail()}</td>
            </tr>
        </table>
    </main>
</div>
</body>
</html>