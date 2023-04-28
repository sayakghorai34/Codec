        let notes = [];
        let notes2 = [];
        let notes3 = [];
        let notes4 = [];
        let notes5 = [];
        let notes6 = [];
        let notes7 = [];
        let notes8 = [];
        let notes9 = [];
        let notes10 = [];
        let notes11 = [];
        const date = document.getElementById("date");
        const mybutton = document.getElementById("scroll_down");

        document.getElementById("form_1").onsubmit = (e) => {
            e.preventDefault();
            const title1 = document.getElementById("title1");
            console.log(title1.value, date.value);
            if (!title1 && title1.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote1(title1.value, date.value);
            document.querySelector("form_1").reset();
        };

        document.getElementById("form_2").onsubmit = (e) => {
            e.preventDefault();
            const title2 = document.getElementById("title2");
            console.log(title2.value, date.value);
            if (!title2 && title2.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote2(title2.value, date.value);
            // document.querySelector("form_2").reset();
        };
        
        document.getElementById("form_3").onsubmit = (e) => {
            e.preventDefault();
            const title3 = document.getElementById("title3");
            console.log(title3.value, date.value);
            if (!title3 && title3.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote3(title3.value, date.value);
            document.querySelector("form_3").reset();
        };
       
        document.getElementById("form_4").onsubmit = (e) => {
            e.preventDefault();
            const title4 = document.getElementById("title4");
            console.log(title4.value, date.value);
            if (!title4 && title4.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote4(title4.value, date.value);
            document.querySelector("form_4").reset();
        };
        
        document.getElementById("form_5").onsubmit = (e) => {
            e.preventDefault();
            const title4 = document.getElementById("title5");
            console.log(title5.value, date.value);
            if (!title5 && title5.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote5(title5.value, date.value);
            document.querySelector("form_5").reset();
        };
        
        document.getElementById("form_6").onsubmit = (e) => {
            e.preventDefault();
            const title6 = document.getElementById("title6");
            console.log(title6.value, date.value);
            if (!title6 && title6.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote6(title6.value, date.value);
            document.querySelector("form_6").reset();
        };
        
        document.getElementById("form_7").onsubmit = (e) => {
            e.preventDefault();
            const title7 = document.getElementById("title7");
            console.log(title7.value, date.value);
            if (!title7 && title7.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote7(title7.value, date.value);
            document.querySelector("form_7").reset();
        };
        
        document.getElementById("form_8").onsubmit = (e) => {
            e.preventDefault();
            const title8 = document.getElementById("title8");
            console.log(title8.value, date.value);
            if (!title8 && title8.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote8(title8.value, date.value);
            document.querySelector("form_8").reset();
        };
        
        document.getElementById("form_9").onsubmit = (e) => {
            e.preventDefault();
            const title9 = document.getElementById("title9");
            console.log(title9.value, date.value);
            if (!title9 && title9.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote9(title9.value, date.value);
            document.querySelector("form_9").reset();
        };
        
        document.getElementById("form_10").onsubmit = (e) => {
            e.preventDefault();
            const title10 = document.getElementById("title10");
            console.log(title10.value, date.value);
            if (!title10 && title10.trim() === "" && !date && date.trim() === "") {
                return console.log("invalid inputs");
            }
            createNote10(title10.value, date.value);
            document.querySelector("form_10").reset();
        };






        function createNote1(title1, date) {
            const newNote1 = { title1, date, id: Date.now() };
            notes.push(newNote1);
            localStorage.setItem("notes", JSON.stringify(notes));
            console.log(notes);
            displayNotes1();
        }
        
        
        function createNote2(title2, date) {
            const newNote2 = { title2, date, id: Date.now() };
            notes2.push(newNote2);
            localStorage.setItem("notes2", JSON.stringify(notes2));
            console.log(notes2);
            displayNotes2();
        }
        function createNote3(title3, date) {
            const newNote3 = { title3, date, id: Date.now() };
            notes3.push(newNote3);
            localStorage.setItem("notes3", JSON.stringify(notes3));
            console.log(notes3);
            displayNotes3();
        }
        
        function createNote4(title4, date) {
            const newNote4 = { title4, date, id: Date.now() };
            notes4.push(newNote4);
            localStorage.setItem("notes4", JSON.stringify(notes4));
            console.log(notes4);
            displayNotes4();
        }
        
        function createNote5(title5, date) {
            const newNote5 = { title5, date, id: Date.now() };
            notes5.push(newNote5);
            localStorage.setItem("notes5", JSON.stringify(notes5));
            console.log(notes5);
            displayNotes5();
        }
        
        function createNote6(title6, date) {
            const newNote6 = { title6, date, id: Date.now() };
            notes6.push(newNote6);
            localStorage.setItem("notes6", JSON.stringify(notes6));
            console.log(notes6);
            displayNotes6();
        }
        
        function createNote7(title7, date) {
            const newNote7 = { title7, date, id: Date.now() };
            notes7.push(newNote7);
            localStorage.setItem("notes7", JSON.stringify(notes7));
            console.log(notes7);
            displayNotes7();
        }
        
        function createNote8(title8, date) {
            const newNote8 = { title8, date, id: Date.now() };
            notes8.push(newNote8);
            localStorage.setItem("notes8", JSON.stringify(notes8));
            console.log(notes8);
            displayNotes8();
        }
        
        function createNote9(title9, date) {
            const newNote9 = { title9, date, id: Date.now() };
            notes9.push(newNote9);
            localStorage.setItem("notes9", JSON.stringify(notes9));
            console.log(notes9);
            displayNotes9();
        }
        
        function createNote10(title10, date) {
            const newNote10 = { title10, date, id: Date.now() };
            notes10.push(newNote10);
            localStorage.setItem("notes10", JSON.stringify(notes10));
            console.log(notes10);
            displayNotes10();
        }





        function displayNotes1() {
            notes = JSON.parse(localStorage.getItem("notes"));
            console.log(notes);
            const ul1 = document.getElementById("ul1");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title1;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul1.appendChild(li);
                ul1.className="yui";
            });
        }
        
        
        function displayNotes2() {
            notes2 = JSON.parse(localStorage.getItem("notes2"));
            console.log(notes2);
            const ul2 = document.getElementById("ul2");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes2.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title2;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul2.appendChild(li);
                ul2.className="yui";
            });
        }
        function displayNotes3() {
            notes3 = JSON.parse(localStorage.getItem("notes3"));
            console.log(notes3);
            const ul3 = document.getElementById("ul3");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes3.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title3;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul3.appendChild(li);
                ul3.className="yui";
            });
        }

        function displayNotes4() {
            notes4 = JSON.parse(localStorage.getItem("notes4"));
            console.log(notes4);
            const ul4 = document.getElementById("ul4");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes4.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title4;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul4.appendChild(li);
                ul4.className="yui";
            });
        }

        function displayNotes5() {
            notes5 = JSON.parse(localStorage.getItem("notes5"));
            console.log(notes5);
            const ul5 = document.getElementById("ul5");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes5.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title5;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul5.appendChild(li);
                ul5.className="yui";
            });
        }

        function displayNotes6() {
            notes6 = JSON.parse(localStorage.getItem("notes6"));
            console.log(notes6);
            const ul6 = document.getElementById("ul6");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes6.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title6;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul6.appendChild(li);
                ul6.className="yui";
            });
        }

        function displayNotes7() {
            notes7 = JSON.parse(localStorage.getItem("notes7"));
            console.log(notes7);
            const ul7 = document.getElementById("ul7");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes7.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title7;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul7.appendChild(li);
                ul7.className="yui";
            });
        }

        function displayNotes8() {
            notes8 = JSON.parse(localStorage.getItem("notes8"));
            console.log(notes8);
            const ul8 = document.getElementById("ul8");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes8.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title8;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul8.appendChild(li);
                ul8.className="yui";
            });
        }

        function displayNotes9() {
            notes9 = JSON.parse(localStorage.getItem("notes9"));
            console.log(notes9);
            const ul9 = document.getElementById("ul9");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes9.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title9;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul9.appendChild(li);
                ul9.className="yui";
            });
        }

        function displayNotes10() {
            notes10 = JSON.parse(localStorage.getItem("notes10"));
            console.log(notes10);
            const ul10 = document.getElementById("ul10");
            document.querySelectorAll("li").forEach((child) => child.remove());
            notes10.forEach((note) => {
                const li = document.createElement("li");
                const div = document.createElement("div");
                const h6 = document.createElement("h6");
                const caption = document.createElement("caption");
                caption.innerText = note.title10;
                h6.innerText = note.date;
                div.appendChild(caption);
                div.appendChild(h6);
                li.appendChild(div);
                ul10.appendChild(li);
                ul10.className="yui";
            });
        }





        
        function item_1() {
            document.getElementById("item-1").checked = true;
            displayNotes1();
        }
        function item_2() {
            document.getElementById("item-2").checked = true;
            displayNotes2();
        }
        function item_3() {
            document.getElementById("item-3").checked = true;
            displayNotes3();
        }
        function item_4() {
            document.getElementById("item-4").checked = true;
            displayNotes4();
        }
        function item_5() {
            document.getElementById("item-5").checked = true;
            displayNotes5();
        }
        function item_6() {
            document.getElementById("item-6").checked = true;
            displayNotes6();
        }
        function item_7() {
            document.getElementById("item-7").checked = true;
            displayNotes7();
        }
        function item_8() {
            document.getElementById("item-8").checked = true;
            displayNotes8();
        }
        function item_9() {
            document.getElementById("item-9").checked = true;
            displayNotes9();
        }
        function item_10() {
            document.getElementById("item-10").checked = true;
            displayNotes10();
        }

        function pfp_open() {
            const ele1 = document.getElementById("pfp");
            const ele2 = document.getElementById("arrow");
            const ele3 = document.getElementById("arrow_span0");
            const ele4 = document.getElementById("pfp_zoom");
            if (ele1.className == "profile_closed") {
              ele1.className = "profile_closed profile_open";
            } else {
              ele1.className = "profile_closed";
            }
            if (ele2.className == "old_arrow") {
              ele2.className = "arrow";
            } else {
              ele2.className = "old_arrow";
            }
            if (ele3.className == "arrow_span0") {
              ele3.className = "arrow_span";
            } else {
              ele3.className = "arrow_span0";
            }
            if (ele4.className == "pfp_zoom") {
              ele4.className = "pfp_zoom pfp_zoom1";
            } else {
              ele4.className = "pfp_zoom";
            }
        }

        function pad(num) {
            return String("0" + num).slice(-2);
        }
        function updateClock() {
            var now = new Date();
            var date = pad(now.getHours()) + ":" + pad(now.getMinutes());
            document.getElementById("date").value = date;
        }
        window.onload = () => {
            displayNotes1();
            setInterval(updateClock, 500);
        };