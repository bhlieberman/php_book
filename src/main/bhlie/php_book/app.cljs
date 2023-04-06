(ns bhlie.php-book.app
  #_{:clj-kondo/ignore [:unused-referred-var]}
  #_{:clj-kondo/ignore [:unused-namespace]}
  (:require [bhlie.php-book.history :refer [navigate]]
            [bhlie.php-book.forms :refer [validate]]))

(defn count-history []
  (.log js/console (.-length js/history)))

(defn init []
  (let [url (.. js/document -links -mylink -href)]
    (count-history)
    (navigate)
    #_(.go js/history -1)
    (.write js/document (str "The text of my link is " url))))