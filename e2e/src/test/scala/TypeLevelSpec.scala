import com.trueaccord.pb.Point2D
import com.trueaccord.proto.e2e.type_level.UsesMessageLevelType
import org.scalatest.{FlatSpec, MustMatchers}

class TypeLevelSpec extends FlatSpec with MustMatchers {
  "message level type" should "generate correct types" in {
    val t = UsesMessageLevelType().update(
      _.optPoint := Point2D(3, 17),
      _.repPoint := Seq(Point2D(15, 19), Point2D(24, 35)),
      _.mapPoint := Map(3 -> Point2D(3, 17), 25 -> Point2D(14, 19))
    )
    UsesMessageLevelType.parseFrom(t.toByteArray) must be(t)
  }

}
