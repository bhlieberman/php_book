(ns bhlie.php-book.history
  (:import goog.History
           [goog.history EventType])
  (:require
   [goog.events]))

;; (def history (History. true (TrustedResourceUrl/fromConstant (Const/from "http://localhost:8080/blank.html"))))

(defn navigate []
  (doto (History.)
    (goog.events/listen EventType.NAVIGATE (fn [^js e] (js/console.log (str "navigated to state" ^js (.-token e)))))
        (.setEnabled true)))