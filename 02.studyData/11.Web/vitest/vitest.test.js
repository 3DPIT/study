import { describe, it } from "vitest";

describe("suite", () => {
  it("serial test", async () => {
    /*... */
  });
  it.concurrent("concurrent test1", async ({ expect }) => {
    /* ... */
  });
  it.concurrent("concurrent test2", async ({ expect }) => {
    /* ... */
  });
});
