import json
from typing import Dict

import numpy as np
import tensorflow as tf
import pandas as pd
from flask import Flask, jsonify, request

dataset = pd.read_csv("https://raw.githubusercontent.com/fachrul-rh/influeHands-ML/main/Dataset/Instagram.csv")
app = Flask(__name__)
data = np.load("ig.npy")
ig_name = dataset.loc[: , "Username Instagram"]
# ig_name = [
#         "@sabdaps",
#         "@btr_alicee",
#         "@halohanie",
#         "@vinamuliana",
#         "@fadiljaidi",
#         "@anisarahim",
#         "@aisyafputri",
#         "@keanuagl",
#         "@fiersabesari",
#         "@btr_babyla",
#         "@cnlulaby",
#         "@inezkristanti",
#         "@eatandtreats",
#         "@greyspolii",
#         "@feliciaputritjiasaka",
#         "@pufflovaa",
#         "@punipun7",
#         "@jeremiahlakhwani",
#         "@ernandaputra",
#         "@sarahgibson21",
#         "@jennyjusuf",
#         "@gadgetins",
#         "@ariefmuhammad",
#         "@sumargodenny",
#         "@tasyiiathasyia",
#         "@tasyafarasya",
#         "@ridhomsakti",
#         "@riaricis1795",
#         "@aprirokh_",
#         "@cacatengker",
#         "@miawaug",
#         "@shitlicious",
#         "@srl789",
#         "@kristanto_pd",
#         "@annisast",
#         "@lestykejora",
#         "@sheggario",
#         "@jonathanend",
#         "@sallytanudjaja",
#         "@amrazing",
#         "@b_channel_indonesia",
#         "@attahalilintar",
#         "@raniazzhr",
#         "@lucintaluna",
#         "@motomobitv",
#         "@galanghendra55real",
#         "@fitra.eri",
#         "@iwanbanaranblog",
#         "@gadgetboy.id",
#         "@sabrinachairunnisa_",
#         "@andhika.diskartes",
#         "@mgdalenaf",
#         "@dr.shindyputri_",
#         "@wegodevindonesia",
#         "@nexcarlos",
#         "@pritaghozie",
#         "@dr., tirta",
#         "@jenniferbachdim",
#         "@htanoko",
#         "@gadgetempireid",
#         "@junarsyi",
#         "@najwashihab",
#         "@autonetmagz",
#         "@kenandgrat",
#         "@antontanjung",
#         "@aurelie.hermansyah",
#         "@umayshahab",
#         "@bramastavrl",
#         "@adindafala",
#         "@natashawilona12",
#         "@andysenjaya",
#         "@raffinagita1717",
#         "@dhiarcom",
#         "@petitedivaa",
#         "@aevafatma",
#         "@mrshananto",
#         "@wisnukumoro",
#         "@kokobuncit",
#         "@ramadhaniabakrie",
#         "@yohanes.cahya",
#         "@bangripiu",
#         "@ellenmay_official",
#         "@marischkaprue",
#         "@ibnujamilo",
#         "@lunamaya",
#         "@sabrinasameh",
#         "@ashanty_ash",
#         "@dicoding",
#         "@raisa6690",
#         "@sarwendah29",
#         "@jscmila",
#         "@_irishbella_",
#         "@drmita.spkk",
#         "@ryanfilbert",
#         "@ayutingting92",
#         "@gisel_la",
#         "@sassychris1",
#         "@ivan_gunawan",
#         "@sukabalapmotor",
#         "@hilmasta",
#         "@kevin_sanjaya",
#         "@pengamatsepakbola",
#         "@zahmuz12",
#         "@bayusaptaji",
#         "@rivannurmulki",
#         "@king.chayra",
#         "@yollayuliana1515",
#         "@hendrasansan",
#         "@valdo_haay",
#         "@edwardcandraa",
#         "@anindyakputri",
#         "@bobbyida",
#         "@danielwenas",
#         "@andreoktvn7",
#         "@aeroaswar",
#         "@imanusman",
#         "@jeromepolin",
#         "@schoters",
#         "@basyasman",
#         "@karinadila8921",
#         "@syafiiefendi",
#         "@marioteguh",
#         "@sherlyannavita",
#         "@renattamoeloek",
#         "@arnoldpo",
#         "@yackikuka",
#         "@resepyummy",
#         "@junarorimpandeyofficial",
#         "@endeus.tv",
#         "@jktfooddestination",
#         "@tanboy_kun",
#         "@abellyc",
#         "@tintinrayner",
#         "@sharazaaa",
#         "@jessicadavaa",
#         "@nala_rinaldo",
#         "@dzawin_nur",
#         "@gunungindonesia",
#         "@puanindya",
#         "@petrichor218",
#         "@nazlaalifa",
#         "@liburanbali",
#         "@thekhayalan",
#         "@agusm123",
#         "@maria_vaniaa",
#         "@missnyctagina",
#         "@andrew.white._",
#         "@dr.okypratamaa",
#         "@zaidulakbar",
#         "@rinaldi_ni",
#         "@wahyuhidayatt_",
#         "@sobat_hape",
#         "@papersboy",
#         "@arrinish",
#         "@herrysw",
#         "@wasawirman",
#         "@akmalriadi",
#         "@indratechlife",
#         "@thelazygadgets",
#         "@k2gadgets",
#         "@bestindotech",
#         "@lokpromedia",
#         "@sahamtalk",
#         "@kefasevander",
#         "@syam_elmarusy",
#         "@ternakuang.id",
#         "@ellenmay_official",
#         "@attarischa",
#         "@itswilliamldj",
#         "@indahwarsetio",
#         "@mirahayunandaanindita",
#         "@teddy.diego",
#         "@azizpict",
#         "@zataligouw",
#         "@otomotifweekly",
#     ]

def prediction(input: np.array) -> Dict:
    output = input[None] @ data
    output = tf.constant(output)
    output = output / tf.reduce_sum(output, axis=1, keepdims=True)
    top_5 = tf.nn.top_k(output, k=5)[1][0]
    result = [ig_name[int(index)] for index in top_5]
    return {"result" : result}

def convert_json_to_np(input: Dict) -> np.array:
    keys = ["Food & Cooking", "Fashion", "Entertainment", "Travel & Accomodation", "Beauty", "Healthcare", "Technology", "Automotive", "Education", "Sports", "Finance", "Tips & Trick About Career"]
    result = []
    for key in keys:
        result.append(input.get(key))
    return np.array(result)
    
    
@app.route("/", methods=["GET", "POST"])
def main():
    if request.method == "POST":
        if request.json is None:
            return jsonify({"error" : "no data"})
        
        try:
            input =  request.get_json()
            input = convert_json_to_np(input)
            result = prediction(input)
            result = json.dumps(result)
            return result
        except Exception as e:
            return jsonify({"error": str(e)})
        
    return "OK"


if __name__ == "__main__":
    app.run(debug=True)
