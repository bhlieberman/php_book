<?php // formtest.php
if (!empty($_POST['name'])) $name = $_POST['name'];
else $name = "Not entered";

echo <<<_END
<html>
<head>
<title>Form Test</title>
</head>
<body>
Your name is $name<br>
<form method="POST" action="formtest.php">
What is your name?
<input type="text" name="name">
<input type="submit">
</form>
</body>
</html>

_END;

?>