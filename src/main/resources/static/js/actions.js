const init = () => {
	const clockElement = document.getElementById('clock');
	const inputElement = document.getElementById('ownTimeInput');
	const ownTextExpressionElement = document.getElementById('ownTextExpression');
	const textExpressionElement = document.getElementById('textExpression');

	const timeNow = () => {
		return new Date().toLocaleTimeString([], {hour: '2-digit', minute:'2-digit'});
	}

	const updateElementWithNewSpokenTime = (time, element) => {
		fetch("/api?time=" + time).then((response) => {
			return response.json();
		}).then((data) => {
			if(data.status && data.status === 'BAD_REQUEST') {
				element.innerHTML = data.message;
			} else {
				element.innerHTML = 'It\'s ' + data.text;
			}
		});
	}
	
	const updateClock = () => {
		let now = timeNow();
		updateElementWithNewSpokenTime(now, textExpressionElement);
		clockElement.innerHTML = now;
	}

	updateClock();
	setInterval(() => {
		updateClock();
	}, 5000);

	inputElement.addEventListener("keyup", (event) => {
		if (event.keyCode === 13 /* enter key code */) {
			const inputText = inputElement.value;
			updateElementWithNewSpokenTime(inputText, ownTextExpressionElement);
		}
	});
};

init();