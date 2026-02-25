package level4

case class Pan(heated: Boolean = false)
case class Egg(cracked: Boolean = false)
case class CookedDish(name: String)
case class ServedDish(review: String)

// ── pure, unary step-functions ────────────────────────────────────────────────

// Step 1: get a cold pan
def getPan(): Pan = Pan(heated = false)

// Step 2: heat the pan — Pan => Pan
def heatPan(pan: Pan): Pan =
  println("🔥 Heating the pan...")
  pan.copy(heated = true)

// Step 3: crack an egg into the hot pan — Pan => Egg
def crackEgg(pan: Pan): Egg =
  require(pan.heated, "Pan must be heated before cracking an egg!")
  println("🥚 Cracking egg into the pan...")
  Egg(cracked = true)

// Step 4: cook the egg — Egg => CookedDish
def cook(egg: Egg): CookedDish =
  require(egg.cracked, "Egg must be cracked before cooking!")
  println("🍳 Cooking the egg...")
  CookedDish(name = "fried egg")

// Step 5: serve the dish — CookedDish => ServedDish
def serve(dish: CookedDish): ServedDish =
  println(s"🍽️  Serving ${dish.name}...")
  ServedDish(review = "this dish is great")

// ── orchestration via andThen (function composition) ─────────────────────────
//
//  andThen chains  f andThen g  so that:
//    result = g(f(input))
//
//  heatPan andThen crackEgg andThen cook andThen serve
//  builds one composed function:  Pan => ServedDish
//
val makeDish: Pan => ServedDish =
  heatPan andThen crackEgg andThen cook andThen serve

@main def runLevel4(): Unit =
  println("=== Level 4: Function Orchestration with andThen ===\n")

  val pan = getPan() // get the starting ingredient
  val servedDish = makeDish(pan) // run the composed pipeline

  println(s"\n✅ Review: \"${servedDish.review}\"")
