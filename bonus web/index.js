/**
 * @type {HTMLButtonElement}
 */
const addButton = document.querySelector("[data-add-button]");
/**
 * @type {HTMLButtonElement}
 */
const calculateMinumumButton = document.querySelector(
	"[data-calculate-minimum-button]"
);
/**
 * @type {HTMLInputElement}
 */
const input = document.querySelector("[data-input]");
/**
 * @type {HTMLParagraphElement}
 */
const output = document.querySelector("[data-output]");

/**
 * @type {number[]}
 */
const numbers = [];

addButton.onclick = (_) => {
	const currentNumber = parseInt(input.value);
	if (currentNumber != NaN) numbers.push(currentNumber);
};

calculateMinumumButton.onclick = (_) => {
	const minimum = numbers.reduce((previous, current) => {
		if (current < previous) return current;
		return previous;
	});

	output.innerHTML = minimum;
};
