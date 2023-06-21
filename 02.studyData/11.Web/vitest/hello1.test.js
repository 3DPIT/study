import { test, expect } from "vitest";

function sum(...nums) {
  return nums.reduce((a, b) => a + b, 0);
}

test("1+1", () => {
  expect(sum(1, 1)).toEqual(2);
});

test("1+1+1", () => {
  expect(sum(1, 1, 1)).toEqual(3);
});
test;
