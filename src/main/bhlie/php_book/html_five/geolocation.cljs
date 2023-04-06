(ns bhlie.php-book.html-five.geolocation)

(defn geo-find-me []
  (let [status (.querySelector js/document "#status")
        map-link (.querySelector js/document "#map-link")
        success (fn [position]
                  (let [latitude (.. position -coords -latitude)
                        longitude (.. position -coords -longitude)]
                    (set! (.-textContent status) "")
                    (set! (.-href map-link) (str "https://www.openstreetmap.org/#map=18/" latitude "/" longitude))))
        error (fn [] (set! (.-textContent status) "Unable to retrieve your location"))]
    (set! (.-href map-link) "")
    (set! (.-textContent map-link) "")
    (set! (.-textContent status) (if (not (.-geolocation js/navigator)) 
                                   "Geolocation is not supported by your browser" 
                                   (.getCurrentPosition (.-geolocation js/navigator) success error)))))

(defn ^:dev/after-load run [] (.addEventListener (.querySelector js/document "#find-me") "click" geo-find-me))