import io
import sys
import unittest
from contextlib import redirect_stdout

sys.stdin = io.StringIO("""\
4
2
13
37
100
""")

result = """\
1
2
6
15
"""

f = io.StringIO()

with redirect_stdout(f):
    import EC_56_2_A

    class Test(unittest.TestCase):
        def test_result(self):
            self.assertEqual(result, f.getvalue())

unittest.main()
