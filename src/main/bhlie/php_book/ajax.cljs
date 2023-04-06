(ns bhlie.php-book.ajax
  (:import [goog.net CorsXmlHttpFactory]))

(defn send-req []
  (let [XHR (js/XMLHttpRequest.)
        info (.getElementById js/document "info")
        resp (doto XHR
               (.open "GET" "http://icanhazip.com")
               (.send))]
    (set! (.-onreadystatechange XHR) (fn [] (set! (.-innerHTML info) (.-responseText resp))))))

(def goog-factory (CorsXmlHttpFactory.))

(defn send-goog-req []
  (let [xhr (.createInstance goog-factory)
        resp (doto xhr 
          (.open "GET" "http://icanhazip.com")
          (.send))]
    (set! (.-onreadystatechange xhr) (fn [] (.log js/console (.-responseText resp))))))

(send-goog-req)