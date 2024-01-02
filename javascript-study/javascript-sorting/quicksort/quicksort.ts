export class QuickSort {
    public sort(values: number[], begin: number, end: number): void {
        if (begin < end) {
            const pivotIndex = this.partition(values, begin, end);
            this.sort(values, begin, pivotIndex -1);
            this.sort(values, pivotIndex + 1, end);
        }
    }

    private partition(values: number[], begin: number, end: number): number {
        const pivot = values[begin]; // pivot value
        let i = begin; // current position to swap

        for (let j = begin + 1; j <= end; j++) {
            if (values[j] <= pivot) {
                i++;
                this.swap(values, j, i);
            }
        }

        this.swap(values, begin, i); // move pivot to meddle

        return i;
    }

    private swap(values: number[], from: number, to: number): void {
        const tmpFrom = values[from];
        values[from] = values[to];
        values[to] = tmpFrom;
    }
}

const values = [7, 6, 1, 8, 2, 9, 5, 4];
console.log(values);
new QuickSort().sort(values, 0, values.length - 1); // npx ts-node quicksort.ts
console.log(values);
