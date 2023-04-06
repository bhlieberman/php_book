(ns bhlie.php-book.forms
  (:require [clojure.string :as string]))

(defn validateForename [field]
  (if (string/blank? field) "No forename was entered\n" ""))

(defn validateSurname [field]
  (if (string/blank? field) "No surname was entered\n" ""))

(defn validateUsername [field]
  (cond
    (string/blank? field) "No username was entered\n"
    (< (count field) 5) "Usernames must be at least five characters\n"))

(defn validatePassword [field]
  (cond
    (string/blank? field) "No password was entered\n"
    (< (count field) 6) "Passwords must be at least six characters\n"
    (not (.test (js/RegExp "[a-z]*|[A-Z]*|[0-9]*") field)) "Passwords required one each of a-z, A-Z and 0-9\n"))

(defn validateAge [field]
  (if
    (or (string/blank? field) (js/isNaN field)) "No age was entered\n"
    (when-not (< 18 field 110) "Age must be between 18 and 110\n")))

(defn validate [^js form]
  (let [fname (.. form -forename -value)
        sname (.. form -surname -value)
        username (.. form -username -value)
        password (.. form -password -value)
        age (.. form -age -value)
        fail (str (validateForename fname) (validateSurname sname)
                  (validateUsername username)  (validatePassword password) (validateAge age))]
    (if (string/blank? fail) true (js/alert fail))))
