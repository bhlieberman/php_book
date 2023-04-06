(ns bhlie.php-book.html-five.lines
  (:require [goog.dom :as gdom]))

(defn draw-lines [c]
  (let [ctx (gdom/getCanvasContext2D c)
        [caps joins] (clj->js [["butt" "round" "square"] ["round" "bevel" "miter"]])]
    (set! (.. c -style -background) "lightblue")
    (set! (.-fillStyle ctx) "red")
    (set! (.-font ctx) "bold 13pt Courier")
    (set! (.-strokeStyle ctx) "blue")
    (set! (.-textBaseline ctx) "top")
    (set! (.-textAlign ctx) "center")
    (set! (.-lineWidth ctx) 20)
    (doseq [i (range 3)
            j (range 3)]
      (set! (.-lineCap ctx) (nth caps i))
      (set! (.-lineJoin ctx) (nth joins j))
      (doto ctx
        (.fillText (str "cap:" (nth caps i)) (+ 88 (* i 180)) (+ 45 (* j 120)))
        (.fillText (str "join:" (nth joins j)) (+ 88 (* j 180)) (+ 65 (* j 120)))
        (.beginPath)
        (.moveTo (+ 20 (* i 180)) (+ 100 (* j 120)))
        (.lineTo (+ 20 (* i 180)) (+ 20 (* j 120)))
        (.lineTo (+ 155 (* i 180)) (+ 20 (* j 120)))
        (.lineTo (+ 155 (* i 180)) (+ 100 (* j 120)))
        (.stroke)
        (.closePath)))))

(defn draw-star [c]
  (let [ctx (gdom/getCanvasContext2D c)
        orig 160 points 21
        dist (/ js/Math.PI (* points 2))
        scale1 150 scale2 80]
    (set! (.. c -style -background) "lightblue")
    (set! (.-strokeStyle ctx) "orange")
    (set! (.-fillStyle ctx) "yellow")
    (.beginPath ctx)
    (dotimes [j points]
           (let [x (js/Math.sin (* j dist))
                 y (js/Math.cos (* j dist))]
             (.lineTo ctx (+ orig (* x scale1)) (+ orig (* y scale1)))
             (.lineTo ctx (+ orig (* x scale2)) (+ orig (* y scale2)))))
    (doto ctx
          (.closePath)
          (.stroke)
          (.fill))))

(draw-star (gdom/getElement "mycanvas"))