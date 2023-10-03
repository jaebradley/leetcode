class StockSpanner:

    def __init__(self):
        self.values = []

    def next(self, price: int) -> int:
        span = 1
        while self.values and self.values[-1][0] <= price:
            (most_recent_price, most_recent_span) = self.values.pop()
            span += most_recent_span
        self.values.append([price, span])
        return span
