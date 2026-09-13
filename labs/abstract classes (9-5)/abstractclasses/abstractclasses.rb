require "AssessmentBase.rb"

module Abstractclasses
  include AssessmentBase

  def assessmentInitialize(course)
    super("AbstractClasses",course)
    @problems = []
  end

end
