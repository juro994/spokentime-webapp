const clockElement = document.getElementById('clock');
const input = document.getElementById('ownTimeInput');
const ownTextExpressionElement = document.getElementById('ownTextExpression');
const textExpressionElement = document.getElementById('textExpression');

let timeNow = () => {
	return new Date().toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'});
}

let updateTimeNowClockElement = (now) => {
	clockElement.innerHTML = now;
}

let updateElementWithNewSpokenTime = (time, element) => {
	fetch("/api?time=" + time).then((response) => response.json()).then((data) => {
		element.innerHTML = data.text;
	});
}


setInterval(() => {
	let now = timeNow();
	updateElementWithNewSpokenTime(now, textExpressionElement);
	updateTimeNowClockElement(now);
}, 5000);

input.addEventListener("keyup", (event) => {
	  // Number 13 is the "Enter" key on the keyboard
	if (event.keyCode === 13) {
		let inputText = input.value;
		updateElementWithNewSpokenTime(inputText, ownTextExpressionElement);
	}
});