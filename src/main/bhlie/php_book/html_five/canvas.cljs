(ns bhlie.php-book.html-five.canvas
  (:require [goog.dom :as gdom]))

(defonce canvas (gdom/getElement "mycanvas"))

(defn draw-japanese-flag [^js c]
  (try (let [ctx (.getContext c "2d")
             img (.getElementById js/document "myimage")]
         (set! (.-fillStyle ctx) "red")
         (set! (.-style c) "1px solid black")
         (doto ctx
           (.beginPath)
           (.moveTo 160 120)
           (.arc 160 120 70 0 (* js/Math.PI 2) false)
           (.closePath)
           (.fill))
         (set! (.-border img) "1px solid black")
         (set! (.-src img) (.toDataURL c)))
       (catch js/Error _)))

(defn draw-rect [^js c]
  (let [ctx (gdom/getCanvasContext2D c)]
    (set! (.-fillStyle ctx) "blue")
    (.fillRect ctx 20 20 600 200)))

(defn clear-rect [^js c]
  (let [ctx (gdom/getCanvasContext2D c)]
    (.clearRect ctx 40 40 560 160)))

(defn stroke-rect [^js c]
  (let [ctx (gdom/getCanvasContext2D c)]
    (set! (.-strokeStyle ctx) "green")
    (.strokeRect ctx 60 60 520 120)))

(defn add-gradient [^js c]
  (let [ctx (gdom/getCanvasContext2D c)
        gradient (.createLinearGradient ctx 0 80 640 80)]
    (doto gradient
          (.addColorStop 0 "white")
          (.addColorStop 1 "black"))
    (set! (.-fillStyle ctx) gradient)
    (.fillRect ctx 80 80 480 80)))

(defn repeat-image [^js c]
  (let [ctx (gdom/getCanvasContext2D c)
        img (js/Image.)
        _ (set! (.-src img) "32px-Lambda_lc.svg.png")]
    (set! (.-onload img) (fn [] (let [pattern (.createPattern ctx img "repeat")]
                                  (set! (.-fillStyle ctx) pattern)
                                  (.fillRect ctx 20 20 600 200))))))

#_(draw-japanese-flag canvas)

;; (set! (.. canvas -style -background) "lightblue")

;; (draw-rect canvas)

;; (clear-rect canvas)

;; (stroke-rect canvas)

;; (add-gradient canvas)

#_(defn ^:dev/after-load run-ns! [] (repeat-image canvas))