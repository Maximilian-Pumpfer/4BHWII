class Question:

    def __init__(self, lvl, q, a1, a2, a3, a4):
        self._level = lvl
        self._question = q
        self._ans1 = a1
        self._ans2 = a2
        self._ans3 = a3
        self._ans4 = a4

    def __str__(self):
        return self._level + "  " + self._question + "\t" + self._ans1 + " | " + self._ans2 + " | " + self._ans3 + " | " + self._ans4
