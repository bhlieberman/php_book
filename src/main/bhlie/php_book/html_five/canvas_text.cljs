(ns bhlie.php-book.html-five.canvas-text
  (:require [goog.dom :as gdom]))

(defn write-text [^js c]
  (let [ctx (gdom/getCanvasContext2D c)
        img (js/Image.)]
    (set! (.-src img) "wicker.jpg")
    (set! (.-onload img) (fn [] (let [pattern (.createPattern ctx img "repeat")]
                                  (set! (.-fillStyle ctx) pattern)
                                  (.fillText ctx "WickerpediA" 0 0)
                                  (.strokeText ctx "WickerpediA" 0 0))))))

(defonce canvas (gdom/getElement "mycanvas"))

(write-text canvas)