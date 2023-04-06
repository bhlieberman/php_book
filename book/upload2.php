<?php // upload2.php
echo <<<_END
<html><head><title>PHP Form Upload</title><link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous"></head><body>
<form method='post' action='upload2.php' enctype='multipart/form-data'>
Select a JPG, GIF, PNG, or TIF File:
<input class='form-control' type='file' name='filename' size='10'>
<input class='form-control' type='submit' value='Upload'></form>
_END;

if ($_FILES) {
    $name = $_FILES['filename']['name'];
    switch($_FILES['filename']['type']) {
        case 'image/jpeg': $ext = 'jpg'; break;
        case 'image/gif': $ext = 'gif'; break;
        case 'image/png': $ext = 'png'; break;
        case 'image/tiff': $ext = 'tif'; break;
        default: $ext = ''; break;
    }
    if ($ext) {
        $n = "image.$ext";
        move_uploaded_file($_FILES['filename']['tmp_name'], $n);
        echo "Uploaded image '$name' as '$n':<br>";
        echo "<img src='$n'>";
    }
    else echo "'$name' is not an accepted image file";
}
else echo "No image has been uploaded";

echo "</body></html>";
?>