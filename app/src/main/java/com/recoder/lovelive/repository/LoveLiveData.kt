package com.recoder.lovelive.repository

import com.recoder.lovelive.R
import com.recoder.lovelive.model.LoveLive

object LoveLiveData {
    private val llNames = arrayOf("Yu Takasaki",
    "Ayumu Uehara",
    "Kasumi Nakasu",
    "Setsuna Yuki",
    "Ai Miyashita",
    "Emma Verde",
    "Rina Tennoji",
    "Kanata Konoe",
    "Shizuku Osaka",
    "Karin Asaka")

    private val llIsFavorite = arrayOf(false, false, false, false, false, false, false, false, false, false)

    private val llThumb = intArrayOf(R.drawable.yu_takasaki_thumb,
        R.drawable.ayumu_uehara_thumb,
        R.drawable.kasumi_nakasu_thumb,
        R.drawable.setsuna_yuki_thumb,
        R.drawable.ai_miyashita_thumb,
        R.drawable.emma_verde_thumb,
        R.drawable.rina_tennoji_thumb,
        R.drawable.kanata_konoe_thumb,
        R.drawable.shizuku_osaka_thumb,
        R.drawable.karin_asaka_thumb)

    private val llPhoto = intArrayOf(R.drawable.yu_takasaki,
        R.drawable.ayumu_uehara,
        R.drawable.kasumi_nakasu,
        R.drawable.setsuna_yuki,
        R.drawable.ai_miyashita,
        R.drawable.emma_verde,
        R.drawable.rina_tennoji,
        R.drawable.kanata_konoe,
        R.drawable.shizuku_osaka,
        R.drawable.karin_asaka)

    private val llCv = arrayOf("Hinaki Yano",
    "Aguri Onishi",
    "Mayu Sagara",
    "Tomori Kusunoki",
    "Natsumi Murakami",
    "Maria Sashide",
    "Chiemi Tanaka",
    "Akari Kito",
    "Kaori Maeda",
    "Miyu Kubota")

    private val llYear = intArrayOf(2, 2, 1, 2, 2, 3, 1, 3, 1, 3)

    private val llBirthday = arrayOf("-", "Mar. 1", "Jan. 23", "Aug. 8", "May. 30", "Feb. 5", "Nov. 13", "Dec. 16", "Apr. 3", "Jun. 29")

    private val llBloodType = arrayOf("-", "A", "B", "O", "A", "O", "B", "O", "A", "AB")

    private val llHeight = intArrayOf(156, 159, 155, 154, 163, 166, 149, 158, 157, 167)

    private val llIcon = intArrayOf(R.drawable.yu_icon,
        R.drawable.ayumu_icon,
        R.drawable.kasumi_icon,
        R.drawable.setsuna_icon,
        R.drawable.ai_icon,
        R.drawable.emma_icon,
        R.drawable.rina_icon,
        R.drawable.kanata_icon,
        R.drawable.shizuku_icon,
        R.drawable.karin_icon)

    private val llDescription = arrayOf("A second-year student at Nijigasaki High School. Ayumu's friend since childhood and a big fan of school idols.",
        "A second-year student at Nijigasaki High School. A hard worker who doesn't mind chipping away at her goals. A certain experience drives her to join the school idol scene.",
        "A first-year student at Nijigasaki High School. A huga fan of cute things, her school-idol aspirations are far greater than they are for most. She's also a sore loser who hates being called by the nickname KasuKasu.",
        "A second-year student at Nijigasaki High School. As a school idol, she's powerful performer with a beaming smile. Rumor has it her school-idol word keeps her so busy, nobody's ever seen her at school.",
        "A second-year student at Nijigasai High School. A gifted athlete, she helps out with assorted school teams. Her upbeat, caring attitude has earned her a lot of friends",
        "A third-year student at Nijigasaki High School. A Swiss exchange student with a keen interest in school idols. Quiet and compassionate, she has a love for the mountains and nature of her homeland",
        "A first-year student at Nijigasaki High School. Has trouble expressing her emotions on her face, making people think she's unsociable, but she's actually affable and full of heart.",
        "A third-year student at Nijigasaki High School. Always looks tired, but when it comes to cooking and caring for her little sister, she's got a deep passion",
        "A first-year student at Nijigasaki High School. Well put together and good at her classes, she's a member of both the drama and school idol clubs",
        "A third-year student at Nijigasaki High School. Her looks and proportions go beyond the norm for high-schoolers, and she's submitted photos to fashion magazines. Despite her grown-up looks, she can be surprisingly pure and innocent"
    )

    private val llBackground = arrayOf("Yu is the budding school idol enthusiast of Nijigasaki High School, and is often seen with her characteristic thigh-high socks and twin-tails tips dyed green. She is Ayumu Uehara's inseparable childhood friend, having grown up as neighbors in the same apartment building near Odaiba. Eventually, the two of them ended up at Nijigasaki together and are now classmates. Yu's love for school idols blossomed after seeing a performance of the legendary school idol, Setsuna Yuki. Along with Ayumu, Yu's very first experience of school idols that day would lead her to seek out Nijigasaki's School Idol Club.",
        "An ordinary girl with no exceptional talents, Ayumu is seemingly content with just living a normal high school life. But when she and her best friend, Yu Takasaki, stumbled upon a school idol performance for the first time, a new path would suddenly appear in Ayumu's world. Despite not being able to sing or dance, Ayumu would nevertheless venture on to become a school idol herself.",
        "Kasumi had always dreamed of becoming an idol. Upon entering Nijigasaki, Kasumi would go on to join the School Idol Club as its most passionate member. But when the club fell into disarray, Kasumi's dreams never took off, and she would soon begin to doubt herself. Her sole presence in the club room would serve as a reminder that the School Idol Club has seen better days. Nevertheless, Kasumi still believes in the club and is determined to keep the dream alive. She would continue to strive to become a school idol and hopes to once again participate in club activities, especially with a senpai she adores. Along with Karin Asaka and Setsuna Yuki, she works with Dengeki Online.",
        "When Setsuna saw school idols for the first time, it felt as if \"fate\" was calling out to her; the very reason for becoming a school idol herself. Seemingly always busy with school idol activities, Setsuna had become somewhat of an urban legend among the students at Nijigasaki, with many claiming they had never even seen her at school. Setsuna would always wear her idol outfit whenever she is with the Nijigasaki High School Idol Club.\n" +
                "\n" +
                "But the girl everyone knew as \"Setsuna Yuki\" had actually adopted that name herself, so that her parents would not figure out she was an idol. Setsuna had come from a strict household, where things like anime, manga, and school idols are banned. One reason why she became an urban legend is linked to the fact that she attends the same school as Nana Nakagawa, who has a different appearance than Setsuna.\n" +
                "\n" +
                "Along with Karin Asaka and Kasumi Nakasu, she works with Dengeki Online. The name \"Setsuna Yuki\" came from the characters of a light novel Nana read.",
        "Along with Ayumu Uehara and Rina Tennoji, Ai works with Famitsu App.\n" +
                "\n" +
                "She has known her neighbor, since she was a child, and considers her to be her big sister. Because both of her parents work at her family's restaurant, she was mostly raised by her grandmother.",
        "Emma hails from Switzerland, and like the tranquil and majestic landscapes of the Swiss Alps, possesses a heart that is just as gentle and glowing. Coming from a family with eight younger siblings, she would leave her home country to pursue becoming a school idol in Japan, eventually transferring to Nijigasaki High School. She shares a dorm with Karin Asaka, whom she develops a close friendship with.\n" +
                "\n" +
                "She uses the Italian word \"Buono\" (meaning \"good\") when introducing herself, which indicates that she is from the Italian-speaking part of Switzerland, which includes the canton (Swiss Confederation member state) of Ticino and some southern parts of Grisons. Her family name \"Verde\" means \"green\" in Italian.\n" +
                "\n" +
                "Along with Shizuku Osaka and Kanata Konoe, Emma works with the Love Live! School idol festival app, where the three of them originally appeared as N-rarity characters. She formerly attended the Y.G. International Academy.",
        "In ALL STARS story, she was invited to be a school idol by the player character. Along with Ai Miyashita and Ayumu Uehara, she works with Famitsu App.",
        "Known as the group's \"sleeping beauty,\" Kanata has the uncanny ability to somehow relax anybody in her presence. She formerly attended Shinonome Academy and has a little sister named Haruka. Along with Shizuku Osaka and Emma Verde, Kanata works with the Love Live! School idol festival app.\n" +
                "\n" +
                "Kanata attends Nijigasaki Academy on scholarship, so she studies really hard at night everyday, thus her sleep deprivation.",
        "She formerly attended Seiran High School. Along with Kanata Konoe and Emma Verde, she works with the Love Live! School idol festival app. \n" +
                "\n" +
                "She lives in Kamakura, far from Nijigasaki High School. Shizuku is an only child, and has a female golden retriever named Ophelia.",
        "Karin wanted to become a school idol to boost her self-confidence. Along with Kasumi Nakasu and Setsuna Yuki, she works with Dengeki Online. \n" +
                "\n" +
                "In the Nijigasaki High School dorms, she shares a room with Emma Verde."
    )

    private val llPersonality = arrayOf("Yu adopted a lot of the player character's personality prior to the anime. She is described as insightful, reliable, quick to take action, and very caring of the Nijigasaki idols. She is shown to have a deep passion for idols, which inspires her goals and actions just like her game counterpart.",
        "Ayumu is a hardworking girl that puts her everything into what she does. She is not very skilled in her school idol activities, but she continues to try her hardest. Sometimes, she becomes anxious about her capabilities, but she can be comforted by her fellow idols.\n" +
                "\n" +
                "She is kind, innocent, and sincere, often responding to the mischief from Karin Asaka and Kasumi Nakasu in a pure manner, which throws the two of them off-guard. However, she doesn't do this intentionally and is truly a pure-hearted girl. She tries her best to be helpful to others.\n" +
                "\n" +
                "She can also be rather clumsy at times.",
        "Kasumi is a kind, friendly and lively girl who loves all things cute, and her love for idols is unrivaled in strength and inspiration. Kasumi wants to be number one in any competition she's in, and often resorts to cheating or even sabotage to achieve that goal. As a consequence, she is a sore loser whenever she achieves anything other than first place.\n" +
                "\n" +
                "She hates the nickname Kasukasu (かすかす) which roughly translates to \"just barely\" or \"not quite\", and gets in a bad mood when referred to with it.\n" +
                "\n" +
                "Kasumi spends a lot of her time scheming or thinking up new ways to ensure her own victory; however, these plans often fail or aren't as devious as she thinks.\n" +
                "\n" +
                "Kasumi can also be considerate of her fellow idols and is seen doing things to cheer them up or to be nice to them. For example, she tries to rile up the group when Ayumu Uehara is nervous before their live, and exchanges genuine Christmas gifts with the Dengeki Online group.",
        "Setsuna has an energetic smile and a distinctive style of performing. She is easily excitable and full of energy, and she can be moved emotionally very easily. She lights up whenever she is asked a question about her interests, which include anime, manga, video games, and school idols.\n" +
                "\n" +
                "She takes her passions very seriously, and with regards to being a school idol, always wants to improve. She wants to share her love of school idols with the world, and help others feel more comfortable saying what they love, but she can be too passionate about idol activities, the reason that drove the members of the original School Idol Club apart and forcing her to disband the club afterwards.\n" +
                "\n" +
                "As Nana, she also strives to do well in school, so she always does homework as soon as possible and studies on her off days.\n" +
                "\n" +
                "Setsuna is also very supportive of her friends. For example, in the Dengeki 4-koma, she continued to eat Kasumi's spicy bread in order to not let her down since she cooked it for her and Karin. She tries to encourage everyone to pursue their dreams and is open to helping others with their dancing and singing.",
        "As a suggestible person who's always willing to help, Ai has a lot of friends who can be seen chatting with strangers at any given time. She is also very caring, especially with her family and friends. In the neighborhood she lives, she tends to refer to all sorts of people around as siblings.\n" +
                "\n" +
                "Because she is a gyaru, she can be mistaken as the type to skip school or be rebellious. However, she has very good grades and is very fun-loving and nice, but she can be a bit loud and sometimes serves as a mood-maker to her fellow idols.\n" +
                "\n" +
                "Ai tends to speak very casually, using a lot of slang. She is also known for her puns, many of which are not very funny to those around her. She easily laughs at bad puns, too.\n" +
                "\n" +
                "Despite Ai having a flawless image in school and being very popular, Ai is very down-to-earth and does not perceive herself as better than others, especially her fellow school idols. She even seems unaware of her reputation, as she never pretends to be someone she isn't, nor is she conscious of whatever image she is giving off. In fact, contrary to her \"cool\" and \"popular\" image, Ai's frequent use of puns can sometimes come off as so lame that the other members react with visible exasperation.",
        "Emma is a kind and easygoing girl with a healing nature. She is very cheerful, pleasant, and tries to look after the other idols. She aims to be encouraging and to help others smile.\n" +
                "\n" +
                "Like Shizuku, Emma tends to keep her worries to herself because she doesn't want others to worry about her. She gets nervous easily.\n" +
                "\n" +
                "Having 8 siblings back home, she can relate to Kanata on the joys of being an older sister. Her family regularly sends her video letters so they can stay connected and on weekends, Emma will typically spend an hour chatting with them via webcam.\n" +
                "\n" +
                "In an All Stars bond episode, she reveals that her dream to become a school idol was the reason why she studied Japanese and eventually came to Japan. She first learned about them after seeing a TV show about them in Switzerland on a night where a snowstorm meant she had to spend the night alone. Her pursuit of her dream has also allowed her to combat being homesick.\n" +
                "\n" +
                "It was also revealed in All Stars that she met Mai Natsukawa, the idol that inspired her. The song Aion no Uta is originally Mai's song that she performed during her last concert as an idol.",
        "Rina is not good at conveying emotions on her face. Because of this, she makes use of the \"Rina-chan Board\", a sketchbook that she draws her emotions on. Rina is also friends with Mia, who met her in Chapter 22 of ALL STARS.\n" +
                "\n" +
                "Despite her flaws, Rina is still trying to change herself by communicating and talking more with others. She admires Ai for her confidence and friendliness. Rina gets nervous easily but continues to try her best.\n" +
                "\n" +
                "As a school idol, she hopes that people will cheer for her so she can show everyone her true smile.",
        "Kanata is often seen as being very sleepy and often takes naps during the day. She is very easygoing and prone to napping in the laps of others, although in the Niji-Yon 4-koma series she seems to like Emma's lap the most. She also carries a pillow around with her at school.\n" +
                "\n" +
                "At times, she will appear to be sleeping but is actually awake and listening to what's going on around her.\n" +
                "\n" +
                "Despite seeming always tired, Kanata is motivated as a school idol by her younger sister and others' praise. She often mentions her dream of being able to take a nap with the audience during a performance. Kanata loves being doted on, but is also very sisterly and capable of looking after others. She loves being a big sister, and tends to look after the other idols in various, little ways. Kanata can be very diligent in matters that are important to her. Her grades are good despite her sleepiness.",
        "Shizuku is a level-headed and mature honor student. She is considered a traditional Japanese beauty, and is quite timid at times.\n" +
                "\n" +
                "As seen in the Niji-Yon 4koma, she likes dogs. Shizuku can be easy to tease, however she is able to stand up for herself and others if teasing goes too far. She can sometimes be observed giving a stern talking-to to Kasumi, someone who is the opposite of Shizuku in terms of maturity. \n" +
                "\n" +
                "Due to her responsible nature, Shizuku is also inclined to take on too much responsibility and keep her thoughts to herself. She worries about things quite often. \n" +
                "\n" +
                "Shizuku is passionate about acting, and is very skilled at getting into character. She is also a fan of old movies and novels since she was little. However, this passion leaded her to be anxious because she felt she was the only child who liked these things.",
        "Karin is very mature and gives off a rather seductive vibe. She uses her adult-like looks to her advantage, such as when she tries to tease her underclassmen. She also teaches others how to be sexy and cool like her.\n" +
                "\n" +
                "However, these lessons sometimes backfire when people begin to show her significant attention or respond in a pure manner, as Karin will become embarrassed.\n" +
                "\n" +
                "Sometimes, Karin is a bit more childish and nervous than she lets on, but she mostly keeps up her usual cool demeanor.\n" +
                "\n" +
                "Because of her modeling activities, her grades are below average and she has difficulties waking up in the morning."
    )

    private val llVideo = arrayOf("",
        "H__egMccq38",
        "-PaIHkBrXsU",
        "JFvvCgbHN80",
        "6bTqtOj4514",
        "JqEnrschi1Q",
        "gZWHc0on9Gc",
        "uLrMMzuY4Ro",
        "7mtm8J2rULI",
        "TOoD8iB5NC8"
    )

    private val llSongName = arrayOf("",
        "Dream with You",
        "Poppin' Up!",
        "DIVE!",
        "Saikou Heart",
        "La Bella Patria",
        "Tsunagaru Connect",
        "Butterfly",
        "Solitude Rain",
        "Vivid World"
        )

    private val llSongFile = arrayOf("",
        "https://res.cloudinary.com/zev/video/upload/v1624779889/Love%20Live/dream_with_you_rfoe7r.mp3",
        "https://res.cloudinary.com/zev/video/upload/v1624779890/Love%20Live/poppin_up_kuf4hh.mp3",
        "https://res.cloudinary.com/zev/video/upload/v1624779897/Love%20Live/dive_e2pqot.mp3",
        "https://res.cloudinary.com/zev/video/upload/v1624779889/Love%20Live/saikou_heart_befrf8.mp3",
        "https://res.cloudinary.com/zev/video/upload/v1624779890/Love%20Live/la_bella_patria_ypkx4g.mp3",
        "https://res.cloudinary.com/zev/video/upload/v1624779894/Love%20Live/tsunagaru_connect_iabjfc.mp3",
        "https://res.cloudinary.com/zev/video/upload/v1624779899/Love%20Live/butterfly_mqouex.mp3",
        "https://res.cloudinary.com/zev/video/upload/v1624779892/Love%20Live/solitude_rain_rfrngm.mp3",
        "https://res.cloudinary.com/zev/video/upload/v1624779901/Love%20Live/vivid_world_xmxew3.mp3"
        )

    private val llReferences = arrayOf("https://love-live.fandom.com/wiki/Yu_Takasaki",
        "https://love-live.fandom.com/wiki/Ayumu_Uehara",
        "https://love-live.fandom.com/wiki/Kasumi_Nakasu",
        "https://love-live.fandom.com/wiki/Setsuna_Yuki",
        "https://love-live.fandom.com/wiki/Ai_Miyashita",
        "https://love-live.fandom.com/wiki/Emma_Verde",
        "https://love-live.fandom.com/wiki/Rina_Tennoji",
        "https://love-live.fandom.com/wiki/Kanata_Konoe",
        "https://love-live.fandom.com/wiki/Shizuku_Osaka",
        "https://love-live.fandom.com/wiki/Karin_Asaka"
    )


    val listData : ArrayList<LoveLive>
        get() {
            val list = arrayListOf<LoveLive>()
            for (position in llNames.indices){
                val data = LoveLive()
                data.name = llNames[position]
                data.isFavorite = llIsFavorite[position]
                data.thumbnail = llThumb[position]
                data.photo = llPhoto[position]
                data.cv = llCv[position]
                data.icon = llIcon[position]
                data.year = llYear[position]
                data.birthday = llBirthday[position]
                data.bloodType = llBloodType[position]
                data.height = llHeight[position]
                data.description = llDescription[position]
                data.background = llBackground[position]
                data.personality = llPersonality[position]
                data.video = llVideo[position]
                data.songName = llSongName[position]
                data.songFile = llSongFile[position]
                data.references = llReferences[position]
                list.add(data)
            }
            return list
        }

}